package com.mc.digitechin.digitechin.domain.User.controller;

import java.util.List;

import com.mc.digitechin.digitechin.domain.User.dto.UserDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mc.digitechin.digitechin.domain.User.dto.BaseUser;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO.StudentInfoResponseDTO;
import com.mc.digitechin.digitechin.domain.User.dto.TeacherDTO.TeacherInfoResponseDTO;
import com.mc.digitechin.digitechin.domain.User.service.UserServiceImpl;
import com.mc.digitechin.digitechin.global.common.SuccessResponse;

import lombok.RequiredArgsConstructor;

import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserServiceImpl userServiceImpl;

    @Override
    public ResponseEntity<SuccessResponse<BaseUser>> getProfile() {
        throw new UnsupportedOperationException("Unimplemented method 'getIdentity'");
    }

    @Override
    public ResponseEntity<SuccessResponse<List<TeacherInfoResponseDTO>>> getAllTeachers() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllTeachers'");
    }

    @Override
    public ResponseEntity<SuccessResponse<UserDTO.UserLoginResponseDTO>> postSignIn(@RequestBody UserDTO.UserLoginRequestDTO userLoginRequestDTO) {
        Assert.hasText(userLoginRequestDTO.getEmail(), "이메일은 필수로 입력되어야 합니다");
        Assert.hasText(userLoginRequestDTO.getPassword(), "비밀번호는 필수로 입력되어야 합니다");

        SuccessResponse<UserDTO.UserLoginResponseDTO> response = this.userServiceImpl.createToken(userLoginRequestDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<SuccessResponse<UserDTO.UserJoinResponseDTO>> postSignUp(@RequestBody UserDTO.UserJoinRequestDTO userJoinRequestDTO) {
        Assert.hasText(userJoinRequestDTO.getName(), "이름은 필수로 입력되어야 합니다");
        Assert.hasText(userJoinRequestDTO.getEmail(), "이메일은 필수로 입력되어야 합니다");
        Assert.notNull(userJoinRequestDTO.getBirthDate(), "생년월일은 필수로 입력되어야 합니다");
        Assert.hasText(userJoinRequestDTO.getPassword(), "비밀번호는 필수로 입력되어야 합니다");
        Assert.hasText(userJoinRequestDTO.getConfirmPassword(), "확인 비밀번호는 필수로 입력되어야 합니다");
        Assert.notNull(userJoinRequestDTO.getUserRole(), "역할은 반드시 입력되어야 합니다");
        Assert.state(userJoinRequestDTO.getPassword().equals(userJoinRequestDTO.getConfirmPassword()), "비밀번호가 일치하지 않습니다");

        SuccessResponse<UserDTO.UserJoinResponseDTO> student = this.userServiceImpl.createUser(userJoinRequestDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(student, headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> postLogout() {
        throw new UnsupportedOperationException("Unimplemented method 'postLogout'");
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> postStartToFollow() {
        throw new UnsupportedOperationException("Unimplemented method 'postStartToFollow'");
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> postQuitFollow() {
        throw new UnsupportedOperationException("Unimplemented method 'postQuitFollow'");
    }

    @Override
    public ResponseEntity<SuccessResponse<BaseUser>> patchUpdateMyData() {
        throw new UnsupportedOperationException("Unimplemented method 'patchUpdateMyData'");
    }

    @Override
    public ResponseEntity<SuccessResponse<List<StudentInfoResponseDTO>>> getAllStudents(Pageable pageable) {
        SuccessResponse<List<StudentInfoResponseDTO>> studentList = this.userServiceImpl.findAllStudent(pageable);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(studentList, headers, HttpStatus.OK);
    }
}
