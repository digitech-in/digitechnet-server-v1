package com.mc.digitechin.digitechin.domain.User.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.mc.digitechin.digitechin.domain.User.constants.UserRole;
import com.mc.digitechin.digitechin.domain.User.constants.UserRoleConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * User Entity
 * 
 * @since 1.0.0
 * @author yunjisang
 * @version 1.0.0
 * @Todos : 교사 정보, 팔로워/팔로잉 유저
 */
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    // == 유저 기본 정보 ==
    // id, 이름, 학교 이메일, 역할, 비밀번호, 생성일, 생일
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column(unique = true)
    private String email;

    @Column
    private LocalDateTime birthDate;

    @NotNull
    @Convert(converter = UserRoleConverter.class)
    private UserRole userRole;

    @NotNull
    @Column
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    // === 학생 정보 ==
    // 학년, 반, 번호
    @Column
    private Integer grade;

    @Column
    private Integer classroom;

    @Column
    private Integer classNumber;

    // == 메소드 정의 ==

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}
