package com.azulyoro.back.dto.request;

import com.azulyoro.back.model.Address;
import com.azulyoro.back.util.RegexPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierRequestDto {
    @NotBlank(message = "{request.invalid.blank}")
    private String name;
    private Address address;
    @Pattern(regexp = RegexPatterns.PHONE_PATTERN, message = "{request.invalid.phone}")
    private String phone;
    @Pattern(regexp = RegexPatterns.EMAIL_PATTERN, message = "{request.invalid.email}")
    private String email;
}
