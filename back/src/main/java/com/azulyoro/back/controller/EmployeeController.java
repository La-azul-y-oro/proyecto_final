package com.azulyoro.back.controller;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.RegisterRequest;
import com.azulyoro.back.dto.response.EmployeeResponseDto;
import com.azulyoro.back.service.EntityService;
import com.azulyoro.back.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private IEmployeeService service;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public CustomPage<EmployeeResponseDto> getByPage(Pageable pageable) {
        return service.getByPage(pageable);
    }
}
