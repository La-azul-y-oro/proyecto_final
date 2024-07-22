package com.azulyoro.back;

import com.azulyoro.back.controller.SupplierController;
import com.azulyoro.back.dto.request.SupplierRequestDto;
import com.azulyoro.back.dto.response.SupplierResponseDto;
import com.azulyoro.back.model.Address;
import com.azulyoro.back.model.Supplier;
import com.azulyoro.back.repository.SupplierRepository;
import com.azulyoro.back.service.EntityService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SupplierController.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SupplierControllerTest {
    private static final String BASE_PATH = "/suppliers";
    private static final String ID_ATTR = "$.id";
    private static final String NAME_ATTR = "$.name";
    private static final String PHONE_ATTR = "$.phone";
    private static final String EMAIL_ATTR = "$.email";
    private static final String ADDRESS_STREET_ATTR = "$.address.street";
    private static final String ADDRESS_NUMBER_ATTR = "$.address.number";
    private static final String ADDRESS_FLOOR_ATTR = "$.address.floor";
    private static final String ADDRESS_DEPARTMENT_ATTR = "$.address.department";

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EntityService<SupplierRequestDto, SupplierResponseDto> service;
    @MockBean
    private SupplierRepository repository;

    private Supplier supplier;
    private SupplierRequestDto requestDto;
    private SupplierResponseDto responseDto1;
    private SupplierResponseDto responseDto2;

    private List<SupplierResponseDto> listResponseDto;
    private Address address1;
    private Address address2;

    @BeforeAll
    void setUp() {
        address1 = Address.builder()
                .street("Calle Wallaby")
                .number(42)
                .floor(1)
                .department("c")
                .build();
        address2 = Address.builder()
                .street("Calle falsa")
                .number(123)
                .build();

        supplier = Supplier.builder()
                .id(1L)
                .name("Proveedor Test")
                .phone("3416275157")
                .email("mail@mail.com.ar")
                .isDeleted(false)
                .address(address1)
                .build();

        requestDto = SupplierRequestDto.builder()
                .name("Proveedor Test")
                .phone("3416275157")
                .email("mail@mail.com.ar")
                .address(address1)
                .build();

        responseDto1 = SupplierResponseDto.builder()
                .id(1L)
                .name("Proveedor Test")
                .phone("3416275157")
                .email("mail@uno.com.ar")
                .isDeleted(false)
                .address(address1)
                .build();

        responseDto2 = SupplierResponseDto.builder()
                .id(2L)
                .name("Proveedor Test 2")
                .phone("3414528795")
                .email("mail@dos.com.ar")
                .isDeleted(false)
                .address(address2)
                .build();

        listResponseDto = List.of(responseDto1, responseDto2);
    }

    @Test
    @DisplayName("Get Supplier by ID: must return SupplierResponseDTO with status 200")
    void getSupplierByIdSuccess() throws Exception {
        when(service.getById(1L)).thenReturn(responseDto1);

        mockMvc.perform(get(BASE_PATH + "/{id}", 1L)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath(ID_ATTR).value(1L))
                .andExpect(jsonPath(NAME_ATTR).value("Proveedor Test"))
                .andExpect(jsonPath(PHONE_ATTR).value("3416275157"))
                .andExpect(jsonPath(EMAIL_ATTR).value("mail@uno.com.ar"))
                .andExpect(jsonPath(ADDRESS_STREET_ATTR).value("Calle Wallaby"))
                .andExpect(jsonPath(ADDRESS_NUMBER_ATTR).value(42))
                .andExpect(jsonPath(ADDRESS_FLOOR_ATTR).value(1))
                .andExpect(jsonPath(ADDRESS_DEPARTMENT_ATTR).value("c"));

        verify(service, times(1)).getById(anyLong());
    }

    //TODO cuando este realizado el global excepcion handler
    @Test
    @DisplayName("Get Supplier by ID not found: must return status 404")
    @Disabled
    void getSupplierByIdNotFound() throws Exception {
        when(service.getById(1L)).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(get(BASE_PATH + "/{id}", 1L)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(service, times(1)).getById(anyLong());
    }

    @Test
    @DisplayName("Get All Suppliers (with data): must return status 200")
    void getSupplierAllContainsData() throws Exception {
        when(service.getAll()).thenReturn(listResponseDto);

        MvcResult mvcResult = mockMvc.perform(get(BASE_PATH + "/all")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        List<SupplierResponseDto> responseList = objectMapper.readValue(contentAsString, new TypeReference<List<SupplierResponseDto>>() {
        });

        assertEquals(2, responseList.size());
        assertEquals(1L, responseList.get(0).getId());
        assertEquals("Proveedor Test", responseList.get(0).getName());
        assertEquals("mail@uno.com.ar", responseList.get(0).getEmail());
        assertEquals("3416275157", responseList.get(0).getPhone());
        assertEquals("Calle Wallaby", responseList.get(0).getAddress().getStreet());
        assertEquals(42, responseList.get(0).getAddress().getNumber());
        assertEquals(1, responseList.get(0).getAddress().getFloor());
        assertEquals("c", responseList.get(0).getAddress().getDepartment());
        assertEquals(2L, responseList.get(1).getId());
        assertEquals("Proveedor Test 2", responseList.get(1).getName());
        assertEquals("3414528795", responseList.get(1).getPhone());
        assertEquals("mail@dos.com.ar", responseList.get(1).getEmail());
        assertEquals("Calle falsa", responseList.get(1).getAddress().getStreet());
        assertEquals(123, responseList.get(1).getAddress().getNumber());
        assertNull(responseList.get(1).getAddress().getFloor());
        assertNull(responseList.get(1).getAddress().getDepartment());

        verify(service, times(1)).getAll();
    }

    @Test
    @DisplayName("Get All Suppliers (without data): must return status 200")
    void getSupplierAllWithoutData() throws Exception {
        when(service.getAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(get(BASE_PATH + "/all")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(service, times(1)).getAll();
    }

    @Test
    @DisplayName("Delete supplier by Id: must return status 204")
    void deleteSupplierById() throws Exception {

        mockMvc.perform(delete(BASE_PATH + "/{id}", 1L)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(service, times(1)).delete(anyLong());
    }

    @Test
    @DisplayName("Create Supplier: must return status 201")
    void createSupplierSuccess() throws Exception {
        when(service.create(requestDto)).thenReturn(responseDto1);

        mockMvc.perform(post(BASE_PATH, requestDto)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated());

        verify(service, times(1)).create(any());
    }

    @Test
    @DisplayName("Update Supplier: must return status 200")
    void updateSupplierSuccess() throws Exception {
        when(service.update(1L, requestDto)).thenReturn(responseDto1);

        mockMvc.perform(put(BASE_PATH+"/{id}", 1L)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        verify(service, times(1)).update(anyLong(), any());
    }

    //TODO cuando este realizado el global excepcion handler
    @Test
    @DisplayName("Update Supplier by ID not found: must return status 404")
    @Disabled
    void updateSupplierSuccessNotFound() throws Exception {
        when(service.update(1L, requestDto)).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(put(BASE_PATH+"/{id}", 1L)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        verify(service, times(1)).update(anyLong(), any());
    }

    @Test
    @DisplayName("Get All Suppliers (with data): must return status 200")
    void getSupplierByPageContainsData() throws Exception {
        when(service.getAll()).thenReturn(listResponseDto);

        MvcResult mvcResult = mockMvc.perform(get(BASE_PATH + "/all")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        List<SupplierResponseDto> responseList = objectMapper.readValue(contentAsString, new TypeReference<List<SupplierResponseDto>>() {
        });

        assertEquals(2, responseList.size());
        assertEquals(1L, responseList.get(0).getId());
        assertEquals("Proveedor Test", responseList.get(0).getName());
        assertEquals("mail@uno.com.ar", responseList.get(0).getEmail());
        assertEquals("3416275157", responseList.get(0).getPhone());
        assertEquals("Calle Wallaby", responseList.get(0).getAddress().getStreet());
        assertEquals(42, responseList.get(0).getAddress().getNumber());
        assertEquals(1, responseList.get(0).getAddress().getFloor());
        assertEquals("c", responseList.get(0).getAddress().getDepartment());
        assertEquals(2L, responseList.get(1).getId());
        assertEquals("Proveedor Test 2", responseList.get(1).getName());
        assertEquals("3414528795", responseList.get(1).getPhone());
        assertEquals("mail@dos.com.ar", responseList.get(1).getEmail());
        assertEquals("Calle falsa", responseList.get(1).getAddress().getStreet());
        assertEquals(123, responseList.get(1).getAddress().getNumber());
        assertNull(responseList.get(1).getAddress().getFloor());
        assertNull(responseList.get(1).getAddress().getDepartment());

        verify(service, times(1)).getAll();
    }

    @Test
    @DisplayName("Get All Suppliers (without data): must return status 200")
    void getSupplierByPageWithoutData() throws Exception {
        when(service.getAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(get(BASE_PATH + "/all")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(service, times(1)).getAll();
    }

}
