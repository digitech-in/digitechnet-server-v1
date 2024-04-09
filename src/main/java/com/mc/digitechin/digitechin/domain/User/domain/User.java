package com.mc.digitechin.digitechin.domain.User.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mc.digitechin.digitechin.domain.User.dto.UserDTO;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import com.mc.digitechin.digitechin.domain.User.constants.UserRole;
import com.mc.digitechin.digitechin.domain.User.constants.UserRoleConverter;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * User Entity
 * 
 * @since 1.0.0
 * @author yunjisang
 * @version 1.0.0
 * @Todos : 교사 정보, 팔로워/팔로잉 유저
 */
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    // == 유저 기본 정보 ==
    // id, 이름, 학교 이메일, 역할, 비밀번호, 생성일, 생일
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column(unique = true)
    private String email;

    @Column
    private LocalDate birthDate;

    @NotNull
    @Convert(converter = UserRoleConverter.class)
    private UserRole userRole;

    @NotNull
    @Column
    private String password;

    @CreatedDate
    private LocalDate createdAt;

    @Column
    private Integer grade;

    @Column
    private Integer classroom;

    @Column
    private Integer classNumber;

    public UserDTO.UserJoinResponseDTO toDTO() {
        return UserDTO.UserJoinResponseDTO.builder().id(id).email(email).name(name).build();
    }

    /**
     * 비밀번호를 암호화
     * @param passwordEncoder 암호화 할 인코더 클래스
     * @return 변경된 유저 Entity
     */
    public User hashPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return this;
    }

    /**
     * 비밀번호 확인
     * @param plainPassword 암호화 이전의 비밀번호
     * @param passwordEncoder 암호화에 사용된 클래스
     * @return true | false
     */
    public boolean checkPassword(String plainPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(plainPassword, this.password);
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

    public void setPassword(String password) {
        this.password = password;
    }
}
