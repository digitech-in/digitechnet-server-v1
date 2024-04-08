package com.mc.digitechin.digitechin.domain.User.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mc.digitechin.digitechin.domain.User.dto.BaseUser;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO.StudentInfoResponseDTO;
import com.mc.digitechin.digitechin.domain.User.dto.Teacher.TeacherInfoResponseDTO;
import com.mc.digitechin.digitechin.domain.User.service.UserServiceImpl;
import com.mc.digitechin.digitechin.global.common.SuccessResponse;

import lombok.RequiredArgsConstructor;

import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserServiceImpl userService;

    @Override
    public ResponseEntity<SuccessResponse<BaseUser>> getIdentity() {
        throw new UnsupportedOperationException("Unimplemented method 'getIdentity'");
    }

    @Override
    public ResponseEntity<SuccessResponse<List<TeacherInfoResponseDTO>>> getAllTeachers() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllTeachers'");
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> postSignIn() {
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> postSignUp() {
        throw new UnsupportedOperationException("Unimplemented method 'postSignUp'");
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
        SuccessResponse<List<StudentInfoResponseDTO>> studentList = this.userService.findAllStudent(pageable);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(studentList, headers, HttpStatus.OK);
    }
}
