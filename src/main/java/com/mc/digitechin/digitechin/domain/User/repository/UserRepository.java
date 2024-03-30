package com.mc.digitechin.digitechin.domain.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mc.digitechin.digitechin.domain.User.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
