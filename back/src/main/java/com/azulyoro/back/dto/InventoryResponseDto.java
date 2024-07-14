package com.azulyoro.back.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponseDto {
    private Long id;
    private Integer amount;
    private SupplierResponseDto supplier;
    private Double costPrice;
    private Double salePrice;
    private SparePartResponseDto sparePart;
}
