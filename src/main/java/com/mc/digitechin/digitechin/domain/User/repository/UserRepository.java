package com.mc.digitechin.digitechin.domain.User.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mc.digitechin.digitechin.domain.User.constants.UserRole;
import com.mc.digitechin.digitechin.domain.User.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> findAllByUserRole(UserRole userRole, Pageable pageable);
}
