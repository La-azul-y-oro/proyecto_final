package com.azulyoro.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.PaymentTypeRequestDto;
import com.azulyoro.back.dto.response.PaymentTypeResponseDto;
import com.azulyoro.back.service.EntityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payment_types")
public class PaymentTypeController {

    @Autowired
    private EntityService<PaymentTypeRequestDto, PaymentTypeResponseDto> service;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public ResponseEntity<List<PaymentTypeResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public ResponseEntity<PaymentTypeResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_ADMIN')")
    public ResponseEntity<PaymentTypeResponseDto> create(@Valid @RequestBody PaymentTypeRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVE', 'ROLE_MECHANIC', 'ROLE_ADMIN')")
    public CustomPage<PaymentTypeResponseDto> getPaymentTypes(Pageable pageable) {
        return service.getByPage(pageable);
    }
}