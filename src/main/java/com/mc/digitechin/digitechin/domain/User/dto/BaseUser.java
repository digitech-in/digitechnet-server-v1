package com.mc.digitechin.digitechin.domain.User.dto;

import java.time.LocalDateTime;

import com.mc.digitechin.digitechin.domain.User.constants.UserRole;

import lombok.Getter;

public class BaseUser {
        private String name;
        private String email;
        private LocalDateTime birth;
        private UserRole userRole;
}
