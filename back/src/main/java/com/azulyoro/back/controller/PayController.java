package com.azulyoro.back.controller;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.PayRequestDto;
import com.azulyoro.back.dto.response.PayResponseDto;
import com.azulyoro.back.service.EntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/pays")
public class PayController {

    @Autowired
    private EntityService<PayRequestDto, PayResponseDto> service;

    @GetMapping("/all")
    public ResponseEntity<List<PayResponseDto>> getAll(){return ResponseEntity.ok(service.getAll());}

    @GetMapping("/{id}")
    public ResponseEntity<PayResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteByid(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PayResponseDto> create(@Valid @RequestBody PayRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayResponseDto> update(@PathVariable Long id, @Valid @RequestBody PayRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @GetMapping
    public CustomPage<PayResponseDto> getPays(Pageable pageable) {return service.getByPage(pageable); }
}
