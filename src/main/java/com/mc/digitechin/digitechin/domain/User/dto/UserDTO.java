package com.mc.digitechin.digitechin.domain.User.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mc.digitechin.digitechin.domain.User.constants.UserRole;
import com.mc.digitechin.digitechin.domain.User.domain.User;
import lombok.*;

import java.time.LocalDate;

public class UserDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UserJoinRequestDTO {
        private String name;
        private String email;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDate birthDate;
        private String password;
        private String confirmPassword;
        private UserRole userRole;
        
        // userRole 에 따라 받는 데이터들이 달라짐
        private int grade;
        private int classroom;
        private int classNumber;


        public User toEntity() {
            return User.builder().name(name).birthDate(birthDate).userRole(userRole).password(password).email(email).grade(grade).classroom(classroom).classNumber(classNumber).build();
        }
    }

    @Getter
    @Builder
    public static class UserJoinResponseDTO {
        private long id;
        private String name;
        private String email;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UserLoginRequestDTO {
        private String email;
        private String password;
    }

    @Getter
    @Builder
    public static class UserLoginResponseDTO {
        private String token;

        public UserLoginResponseDTO(String token) {
            this.token = token;
        }
    }
}
