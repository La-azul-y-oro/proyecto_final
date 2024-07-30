package com.azulyoro.back.controller;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.ServicesRequestDto;
import com.azulyoro.back.dto.response.ServicesResponseDto;
import com.azulyoro.back.service.EntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@CrossOrigin
public class ServicesController {
    @Autowired
    private EntityService<ServicesRequestDto, ServicesResponseDto> service;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public ResponseEntity<List<ServicesResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public ResponseEntity<ServicesResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_ADMIN')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_ADMIN')")
    public ResponseEntity<ServicesResponseDto> create(@Valid @RequestBody ServicesRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public ResponseEntity<ServicesResponseDto> update(@PathVariable Long id,
            @Valid @RequestBody ServicesRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public CustomPage<ServicesResponseDto> getByPage(Pageable pageable) {
        return service.getByPage(pageable);
    }
}
