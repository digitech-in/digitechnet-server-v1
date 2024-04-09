package com.mc.digitechin.digitechin.domain.User.dto;

import com.mc.digitechin.digitechin.domain.User.constants.UserRole;
import lombok.Getter;

import java.time.LocalDateTime;

public class StudentDTO {

    @Getter
    public static class StudentInfoResponseDTO extends BaseUser {
        private long id;
        private long grade;
        private long classroom;
        private long classNumber;

        public StudentInfoResponseDTO(long id, long grade, long classroom, long classNumber) {
            this.id = id;
            this.grade = grade;
            this.classroom = classroom;
            this.classNumber = classNumber;
        }
    }
}
