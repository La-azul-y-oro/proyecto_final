package com.azulyoro.back.controller;

import com.azulyoro.back.dto.request.ClientRequestDto;
import com.azulyoro.back.dto.response.ClientResponseDto;
import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.service.EntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientController {
    @Autowired
    private EntityService<ClientRequestDto, ClientResponseDto> service;

    @GetMapping("/all")
    public ResponseEntity<List<ClientResponseDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> create(@Valid @RequestBody ClientRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> update(@PathVariable Long id, @Valid @RequestBody ClientRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @GetMapping
    public CustomPage<ClientResponseDto> getByPage(Pageable pageable) {
        return service.getByPage(pageable);
    }
}
