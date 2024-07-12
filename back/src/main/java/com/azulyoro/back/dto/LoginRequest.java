package com.azulyoro.back.dto;

import com.azulyoro.back.util.RegexPatterns;

import jakarta.validation.constraints.Pattern;
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
public class LoginRequest {

    @Pattern(regexp = RegexPatterns.EMAIL_PATTERN, message = "{request.invalid.email}")
    private String email;

    private String password;
}
