package org.ardev.user_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.ardev.user_service.mapper.UserMapper;
import org.ardev.user_service.model.dto.user.UserRequest;
import org.ardev.user_service.model.dto.user.UserResponse;
import org.ardev.user_service.model.entity.Country;
import org.ardev.user_service.model.entity.User;
import org.ardev.user_service.repository.UserRepository;
import org.ardev.user_service.service.CountryService;
import org.ardev.user_service.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CountryService countryService;

    @Override
    public Page<UserResponse> findAllUsers(Pageable pageable) {
        return this.userRepository
                .findAll(pageable)
                .map(userMapper::toResponse);
    }

    @Override
    @Transactional
    public UserResponse createUser(UserRequest request) {
        User user = this.userMapper.toEntity(request);
        Country country = this.countryService.findCountryById(request.countryId());
        user.setCountry(country);
        user.setActive(true);
        user = this.userRepository.save(user);
        return this.userMapper.toResponse(user);
    }
}
