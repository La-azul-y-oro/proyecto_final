package com.azulyoro.back.dto.request;

import com.azulyoro.back.model.Address;
import com.azulyoro.back.model.Role;

import com.azulyoro.back.util.RegexPatterns;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "{request.invalid.blank}")
    @Size(max = 50, message = "{request.invalid.max_size}")
    private String name;
    @NotBlank(message = "{request.invalid.blank}")
    @Size(max = 50, message = "{request.invalid.max_size}")
    private String lastName;
    @Pattern(regexp = RegexPatterns.EMAIL_PATTERN, message = "{request.invalid.email}")
    private String email;
    @Positive(message = "{request.invalid.positive}")
    private Long identificationNumber;
    @NotNull(message = "{request.invalid.null}")
    private Role role;
    @NotNull(message = "{request.invalid.null}")
    private Address address;
    @NotNull(message = "{request.invalid.null}")
    private String password;
}
