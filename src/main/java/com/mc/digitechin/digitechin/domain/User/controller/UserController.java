package com.mc.digitechin.digitechin.domain.User.controller;

import java.util.List;

import com.mc.digitechin.digitechin.domain.User.dto.TeacherDTO;
import com.mc.digitechin.digitechin.domain.User.dto.UserDTO;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mc.digitechin.digitechin.domain.User.dto.BaseUser;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO.StudentInfoResponseDTO;
import com.mc.digitechin.digitechin.global.common.SuccessResponse;

@RequestMapping(value = "/api/v1/user")
public interface UserController {
    /**
     * 자신의 유저 데이터를 리턴
     * 
     * @return ResponseEntity<SuccessResponse<BaseUser.getUserDataResponseDTO>>
     */
    @GetMapping("/me")
    public ResponseEntity<SuccessResponse<BaseUser>> getProfile();

    /**
     * 모든 학생들의 데이터를 리턴
     * 
     * @return ResponseEntity<SuccessResponse<List<Student.StudentInfoResponseDTO>>>
     * @throws NotFoundException
     */
    @GetMapping("/students")
    public ResponseEntity<SuccessResponse<List<StudentInfoResponseDTO>>> getAllStudents(
            @PageableDefault(size = 10) Pageable pageable);

    /**
     * 모든 선생님들의 데이터를 리턴
     * 
     * @return ResponseEntity<SuccessResponse<List<TeacherDTO.TeacherInfoResponseDTO>>>
     */
    @GetMapping("/teachers")
    public ResponseEntity<SuccessResponse<List<TeacherDTO.TeacherInfoResponseDTO>>> getAllTeachers();

    /**
     * 로그인
     * 
     * @return ResponseEntity<SuccessResponse<Void>>
     */
    @PostMapping("/signin")
    public ResponseEntity<SuccessResponse<UserDTO.UserLoginResponseDTO>> postSignIn(@RequestBody UserDTO.UserLoginRequestDTO userLoginRequestDTO);


    /**
     * 회원가입
     * 
     * @return ResponseEntity<SuccessResponse<Void>>
     */
    @PostMapping("/signup")
    public ResponseEntity<SuccessResponse<UserDTO.UserJoinResponseDTO>> postSignUp(@RequestBody UserDTO.UserJoinRequestDTO userJoinRequestDTO);

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
