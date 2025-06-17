package org.ardev.user_service.model.dto.user;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record UserRequest(
        @NotBlank(message = "Username cannot be blank") @Size(max = 64)
        String username,
        @NotBlank(message = "Password cannot be blank") @Size(min = 8)
        String password,
        @NotBlank(message = "Email cannot be blank") @Email(message = "Incorrect email format")
        String email,
        @NotBlank(message = "Phone cannot be blank") @Pattern(regexp = "\\+?[0-9]{7,15}")
        String phone,
        @Size(max = 4096)
        String aboutMe,
        @Size(max = 64)
        String city,
        @NotNull Long countryId
) {
}
