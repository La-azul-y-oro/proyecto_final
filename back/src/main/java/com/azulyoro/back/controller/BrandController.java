package com.azulyoro.back.controller;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.BrandRequestDto;
import com.azulyoro.back.dto.BrandResponseDto;
import com.azulyoro.back.service.EntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private EntityService<BrandRequestDto, BrandResponseDto> service;

    @GetMapping("/all")
    public ResponseEntity<List<BrandResponseDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<BrandResponseDto> create(@Valid @RequestBody BrandRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponseDto> update(@PathVariable Long id, @Valid @RequestBody BrandRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @GetMapping
    public CustomPage<BrandResponseDto> getBrands(Pageable pageable) {
        return service.getByPage(pageable);
    }
}
