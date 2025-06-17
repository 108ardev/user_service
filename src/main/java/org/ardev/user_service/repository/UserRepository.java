package org.ardev.user_service.repository;

import org.ardev.user_service.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
