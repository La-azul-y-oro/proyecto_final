package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.ServicesRequestDto;
import com.azulyoro.back.dto.response.ServicesResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.exception.EntityNotFoundOrInactiveException;
import com.azulyoro.back.mapper.ClientMapper;
import com.azulyoro.back.mapper.Mapper;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.model.*;
import com.azulyoro.back.repository.ServicesRepository;
import com.azulyoro.back.util.MessageUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService implements EntityService<ServicesRequestDto, ServicesResponseDto> {
    private class RelatedEntites{
        public Client client;
        public Vehicle vehicle;
        public List<SparePart> spareParts;
        public List<Employee> employees;
        public ServiceType serviceType;
    }
    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private SparePartService sparePartService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private Mapper<Services, ServicesRequestDto, ServicesResponseDto> servicesMapper;

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private PageMapper pageMapper;

    @Override
    public ServicesResponseDto create(ServicesRequestDto requestDto) {
        return saveAndGetResponseDto(null, requestDto);
    }

    @Override
    public ServicesResponseDto update(Long id, ServicesRequestDto requestDto) {

        if(servicesRepository.existsById(id)) {
            return saveAndGetResponseDto(id, requestDto);
        }else{
            throw new EntityNotFoundException(MessageUtil.entityNotFound(id));
        }
    }

    @Override
    public ServicesResponseDto getById(Long id) {
        Services service = servicesRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        return setClientsAndGetResponseDto(service);
    }

    @Override
    public List<ServicesResponseDto> getAll() {
        return servicesRepository
                .findAll()
                .stream()
                .map(this::setClientsAndGetResponseDto)
                .toList();
    }

    @Override
    public CustomPage<ServicesResponseDto> getByPage(Pageable pageable) {
        Page<ServicesResponseDto> page = servicesRepository
                .findAll(pageable)
                .map(this::setClientsAndGetResponseDto);

        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            servicesRepository.softDelete(id);
        } catch (Exception e) {
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }

    private RelatedEntites validateRelatedEntities(ServicesRequestDto servicesRequestDto){
        RelatedEntites relatedEntites = new RelatedEntites();
        relatedEntites.client = validateAndGetClient(servicesRequestDto.getClientId());
        relatedEntites.vehicle = validateAndGetVehicle(servicesRequestDto.getVehicleId());
        relatedEntites.spareParts = validateAndGetSpareParts(servicesRequestDto.getSparePartsIds());
        relatedEntites.employees = validateAndGetEmployees(servicesRequestDto.getEmployeesIds());
        relatedEntites.serviceType = validateAndGetServiceType(servicesRequestDto.getServiceTypeId());

        return relatedEntites;
    }

    private ServiceType validateAndGetServiceType(Long id) {
        var serviceType = serviceTypeService.findById(id);

        if(serviceType.isEmpty() || serviceType.get().isDeleted())
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(id));

        return serviceType.get();
    }

    private List<Employee> validateAndGetEmployees(List<Long> listIds) {
        return listIds
                .stream()
                .map(this::validateAndGetEmployee)
                .toList();
    }

    private List<SparePart> validateAndGetSpareParts(List<Long> listIds) {
        return listIds
                .stream()
                .map(this::validateAndGetSparePart)
                .toList();
    }

    private Vehicle validateAndGetVehicle(Long id) {
        var vehicle = vehicleService.findById(id);

        if(vehicle.isEmpty() || vehicle.get().isDeleted())
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(id));

        return vehicle.get();
    }

    private Client validateAndGetClient(Long id) {
        var client = clientService.findById(id);

        if(client.isEmpty() || client.get().isDeleted())
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(id));

        return client.get();
    }

    private Employee validateAndGetEmployee(Long id) {
        var employee = employeeService.findById(id);

        if(employee.isEmpty() || employee.get().isDeleted())
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(id));

        return employee.get();
    }

    private SparePart validateAndGetSparePart(Long id) {
        var sparePart = sparePartService.findById(id);

        if(sparePart.isEmpty() || sparePart.get().isDeleted())
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(id));

        return sparePart.get();
    }

    private ServicesResponseDto setClientsAndGetResponseDto(Services service){
        var response = servicesMapper.entityToDto(service);
        response.setClient(clientMapper.entityToBasicDto(service.getClient()));

        return response;
    }

    private ServicesResponseDto saveAndGetResponseDto(Long id, ServicesRequestDto requestDto){
        Services service = servicesMapper.dtoToEntity(requestDto);
        service.setId(id);

        RelatedEntites relatedEntites = validateRelatedEntities(requestDto);
        service.setClient(relatedEntites.client);
        service.setVehicle(relatedEntites.vehicle);
        service.setSpareParts(relatedEntites.spareParts);
        service.setEmployees(relatedEntites.employees);
        service.setServiceType(relatedEntites.serviceType);

        return setClientsAndGetResponseDto(servicesRepository.save(service));
    }
}
