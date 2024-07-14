package com.azulyoro.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.ServiceTypeRequestDto;
import com.azulyoro.back.dto.ServiceTypeResponseDto;
import com.azulyoro.back.service.EntityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/service_types")
public class ServiceTypeController {
    @Autowired
    private EntityService<ServiceTypeRequestDto, ServiceTypeResponseDto> service;

    @GetMapping("/all")
    public ResponseEntity<List<ServiceTypeResponseDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceTypeResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ServiceTypeResponseDto> create(@Valid @RequestBody ServiceTypeRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceTypeResponseDto> update(@PathVariable Long id, @Valid @RequestBody ServiceTypeRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @GetMapping
    public CustomPage<ServiceTypeResponseDto> getServiceTypes(Pageable pageable) {
        return service.getByPage(pageable);
    }
}