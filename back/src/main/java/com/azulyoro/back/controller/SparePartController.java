package com.azulyoro.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.SparePartRequestDto;
import com.azulyoro.back.dto.response.SparePartResponseDto;
import com.azulyoro.back.service.EntityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/spare_parts")
@CrossOrigin
public class SparePartController {
    @Autowired
    private EntityService<SparePartRequestDto, SparePartResponseDto> service;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public ResponseEntity<List<SparePartResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public ResponseEntity<SparePartResponseDto> getById(@PathVariable Long id) {
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
    public ResponseEntity<SparePartResponseDto> create(@Valid @RequestBody SparePartRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_ADMIN')")
    public ResponseEntity<SparePartResponseDto> update(@PathVariable Long id,
            @Valid @RequestBody SparePartRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public CustomPage<SparePartResponseDto> getSpareParts(Pageable pageable) {
        return service.getByPage(pageable);
    }
}
