package org.ardev.user_service.model.dto.user;

import java.time.LocalDateTime;

public record UserResponse(
        long id,
        String username,
        String email,
        String phone,
        String aboutMe,
        String city,
        long countryId,
        LocalDateTime createdAt
) {
}
