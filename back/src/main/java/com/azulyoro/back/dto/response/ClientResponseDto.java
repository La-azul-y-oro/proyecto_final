package com.azulyoro.back.dto.response;

import com.azulyoro.back.model.IdentificationType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private IdentificationType category;
    private Long identificationNumber;
    private String email;
    private String businessName;
    //TODO ajustar agregando servicesDTO cuando el mismo esta realizado
}
