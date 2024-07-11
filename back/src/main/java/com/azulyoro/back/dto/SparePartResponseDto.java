package com.azulyoro.back.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SparePartResponseDto {
    private Long id;
    private String name;
    private BrandResponseDto brand;
    private String madeIn;
    private boolean isDeleted;
}
