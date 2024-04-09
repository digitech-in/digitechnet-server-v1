package com.mc.digitechin.digitechin.domain.User.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mc.digitechin.digitechin.domain.User.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM USERS WHERE USER_ROLE = :userRole", nativeQuery = true)
    Optional<List<User>> findAllByUserRole(@Param("userRole") int userRole, Pageable pageable);

    @Query(value = "SELECT * FROM USERS WHERE EMAIL = :email", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);
}
