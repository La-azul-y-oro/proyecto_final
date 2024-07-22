package com.azulyoro.back.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceTypeResponseDto {
    private Long id;
    private String name;
    private String description;
    private boolean isDeleted;
}
