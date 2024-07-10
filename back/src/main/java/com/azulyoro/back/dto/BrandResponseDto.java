package com.azulyoro.back.dto;

import com.azulyoro.back.model.BrandCategory;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandResponseDto {
    private Long id;
    private String name;
    private BrandCategory category;
    private boolean isDeleted;
}
