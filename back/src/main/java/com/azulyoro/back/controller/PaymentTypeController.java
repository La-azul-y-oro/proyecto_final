package com.azulyoro.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PaymentTypeResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentTypeResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PaymentTypeResponseDto> create(@Valid @RequestBody PaymentTypeRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentTypeResponseDto> update(@PathVariable Long id, @RequestBody PaymentTypeRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @GetMapping
    public CustomPage<PaymentTypeResponseDto> getPaymentTypes(Pageable pageable) {
        return service.getByPage(pageable);
    }
}