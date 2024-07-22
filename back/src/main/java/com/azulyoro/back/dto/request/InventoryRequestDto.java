package com.azulyoro.back.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRequestDto {
    @Min(value = 0, message = "{request.invalid.amount}")
    private Integer amount;
    @Min(value = 1, message = "{request.invalid.id_min}")
    private Long supplierId;
    @Positive(message = "{request.invalid.price}")
    private Double costPrice;
    @Positive(message = "{request.invalid.price}")
    private Double salePrice;
    @Min(value = 1, message = "{request.invalid.id_min}")
    private Long sparePartId;
}
