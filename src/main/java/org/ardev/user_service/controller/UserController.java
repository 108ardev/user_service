package org.ardev.user_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ardev.user_service.model.dto.user.UserRequest;
import org.ardev.user_service.model.dto.user.UserResponse;
import org.ardev.user_service.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(OK)
    public Page<UserResponse> getAllUsers(Pageable pageable) {
        return this.userService.findAllUsers(pageable);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public UserResponse createUser(@Valid @RequestBody UserRequest dto) {
        return this.userService.createUser(dto);
    }
}
