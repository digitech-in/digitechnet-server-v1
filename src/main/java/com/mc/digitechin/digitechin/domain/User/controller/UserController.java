package com.mc.digitechin.digitechin.domain.User.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mc.digitechin.digitechin.domain.User.dto.BaseUser;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO.StudentInfoResponseDTO;
import com.mc.digitechin.digitechin.domain.User.dto.Teacher;
import com.mc.digitechin.digitechin.global.common.SuccessResponse;

@RequestMapping(value = "/api/v1/user")
public interface UserController {
    /**
     * 자신의 유저 데이터를 리턴
     * 
     * @return ResponseEntity<SuccessResponse<BaseUser.getUserDataResponseDTO>>
     */
    @GetMapping("/me")
    public ResponseEntity<SuccessResponse<BaseUser>> getIdentity();

    /**
     * 모든 학생들의 데이터를 리턴
     * 
     * @return ResponseEntity<SuccessResponse<List<Student.StudentInfoResponseDTO>>>
     * @throws NotFoundException
     */
    @GetMapping("/students")
    public ResponseEntity<SuccessResponse<List<StudentInfoResponseDTO>>> getAllStudents(
            @PageableDefault(size = 10) Pageable pageable) throws NotFoundException;

    /**
     * 모든 선생님들의 데이터를 리턴
     * 
     * @return ResponseEntity<SuccessResponse<List<Teacher.TeacherInfoResponseDTO>>>
     */
    @GetMapping("/teachers")
    public ResponseEntity<SuccessResponse<List<Teacher.TeacherInfoResponseDTO>>> getAllTeachers();

    /**
     * 로그인
     * 
     * @return ResponseEntity<SuccessResponse<Void>>
     */
    @PostMapping("/signin")
    public ResponseEntity<SuccessResponse<Void>> postSignIn();

    /**
     * 회원가입
     * 
     * @return ResponseEntity<SuccessResponse<Void>>
     */
    @PostMapping("/signup")
    public ResponseEntity<SuccessResponse<Void>> postSignUp();

    /**
     * 로그아웃
     * 
     * @return ResponseEntity<SuccessResponse<Void>>
     */
    @PostMapping("/logout")
    public ResponseEntity<SuccessResponse<Void>> postLogout();

    /**
     * 팔로잉 시작
     * 
     * @return ResponseEntity<SuccessResponse<Void>>
     */
    @PostMapping("/following")
    public ResponseEntity<SuccessResponse<Void>> postStartToFollow();

    /**
     * 팔로잉 취소
     * 
     * @return ResponseEntity<SuccessResponse<Void>>
     */
    @PostMapping("/unfollow")
    public ResponseEntity<SuccessResponse<Void>> postQuitFollow();

    /**
     * 자신의 데이터를 수정 및 저장
     * 
     * @return ResponseEntity<SuccessResponse<BaseUser>>
     */
    @PatchMapping("/update")
    public ResponseEntity<SuccessResponse<BaseUser>> patchUpdateMyData();
}
