package org.ardev.user_service.mapper;

import org.ardev.user_service.model.dto.user.UserRequest;
import org.ardev.user_service.model.dto.user.UserResponse;
import org.ardev.user_service.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface UserMapper {

    User toEntity(UserRequest user);

    @Mapping(target = "countryId", source = "country.id")
    UserResponse toResponse(User user);
}
