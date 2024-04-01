package com.mc.digitechin.digitechin.domain.User.dto;

import lombok.Getter;

public class Student {
    @Getter
    public class StudentInfoResponseDTO extends BaseUser {
        private int grade;
        private int classroom;
        private int classNumber;
    }
}
