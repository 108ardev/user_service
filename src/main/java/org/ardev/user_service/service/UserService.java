package org.ardev.user_service.service;

import org.ardev.user_service.model.dto.user.UserRequest;
import org.ardev.user_service.model.dto.user.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserResponse> findAllUsers(Pageable pageable);

    UserResponse createUser(UserRequest request);
}
