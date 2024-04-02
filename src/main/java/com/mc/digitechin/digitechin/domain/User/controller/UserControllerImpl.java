package com.mc.digitechin.digitechin.domain.User.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mc.digitechin.digitechin.domain.User.dto.BaseUser;
import com.mc.digitechin.digitechin.domain.User.dto.Student.StudentInfoResponseDTO;
import com.mc.digitechin.digitechin.domain.User.dto.Teacher.TeacherInfoResponseDTO;
import com.mc.digitechin.digitechin.global.common.SuccessResponse;

@RestController
public class UserControllerImpl implements UserController {

    @Override
    public ResponseEntity<SuccessResponse<BaseUser>> getIdentity() {
        throw new UnsupportedOperationException("Unimplemented method 'getIdentity'");
    }

    @Override
    public ResponseEntity<SuccessResponse<List<StudentInfoResponseDTO>>> getAllStudents() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllStudents'");
    }

    @Override
    public ResponseEntity<SuccessResponse<List<TeacherInfoResponseDTO>>> getAllTeachers() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllTeachers'");
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> postSignIn() {
        throw new UnsupportedOperationException("Unimplemented method 'postSignIn'");
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

}
