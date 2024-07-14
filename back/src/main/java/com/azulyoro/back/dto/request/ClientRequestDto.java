package com.azulyoro.back.dto.request;

import com.azulyoro.back.model.IdentificationType;
import com.azulyoro.back.util.RegexPatterns;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDto {
    @NotBlank(message = "{request.invalid.blank}")
    @Size(max = 50, message = "{request.invalid.max_size}")
    private String name;
    @NotBlank(message = "{request.invalid.blank}")
    @Size(max = 50, message = "{request.invalid.max_size}")
    private String lastName;
    @NotNull
    private IdentificationType category;
    @Positive(message = "{request.invalid.positive}")
    private Long identificationNumber;
    @Pattern(regexp = RegexPatterns.EMAIL_PATTERN, message = "{request.invalid.email}")
    private String email;
    private String businessName;
}
