package com.mc.digitechin.digitechin.domain.User.constants;

import lombok.Getter;

/**
 * Enum UserRole, 사용자의 분류를 위해 사용 ( 관리자, 학생, 교사)
 * 
 * @author yunjisang
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
public enum UserRole {
    ADMIN(100, "관리자"),
    STUDENT(200, "학생"),
    TEACHER(300, "교사");

    private int codeValue;

    private String role;

    UserRole(int codeValue, String role) {
        this.codeValue = codeValue;
        this.role = role;
    }
}
