package com.azulyoro.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.azulyoro.back.dto.request.VehicleRequestDto;
import com.azulyoro.back.dto.response.VehicleResponseDto;
import com.azulyoro.back.service.EntityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin
public class VehicleController {

    @Autowired
    private EntityService<VehicleRequestDto, VehicleResponseDto> service;

    @GetMapping("/all")
    public ResponseEntity<List<VehicleResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDto> create(@Valid @RequestBody VehicleRequestDto vehicleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(vehicleDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> update(@PathVariable Long id,
            @Valid @RequestBody VehicleRequestDto vehicleDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, vehicleDto));
    }

    @GetMapping
    public CustomPage<VehicleResponseDto> getVehicles(Pageable pageable) {
        return service.getByPage(pageable);
    }
}
