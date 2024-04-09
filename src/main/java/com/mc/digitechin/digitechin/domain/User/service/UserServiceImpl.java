package com.mc.digitechin.digitechin.domain.User.service;

import com.mc.digitechin.digitechin.domain.User.dto.UserDTO;
import com.mc.digitechin.digitechin.global.common.JwtTokenUtil;
import org.springframework.data.domain.Pageable;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import com.mc.digitechin.digitechin.domain.User.constants.UserRole;
import com.mc.digitechin.digitechin.domain.User.domain.User;
import com.mc.digitechin.digitechin.domain.User.dto.TeacherDTO;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO.StudentInfoResponseDTO;
import com.mc.digitechin.digitechin.domain.User.repository.UserRepository;
import com.mc.digitechin.digitechin.global.common.SuccessResponse;
import com.mc.digitechin.digitechin.global.error.CustomException;
import com.mc.digitechin.digitechin.global.error.ErrorCode;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public SuccessResponse<List<StudentInfoResponseDTO>> findAllStudent(Pageable pageable) {
        List<User> students = userRepository.findAllByUserRole(UserRole.STUDENT.getCodeValue(), pageable)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        List<StudentInfoResponseDTO> response = students.stream()
                .map(student -> new StudentInfoResponseDTO(student.getId(), student.getGrade(),
                        student.getClassroom(), student.getClassNumber()))
                .collect(toList());

        return new SuccessResponse<List<StudentInfoResponseDTO>>(true, response);
    }

    @Override
    public SuccessResponse<UserDTO.UserJoinResponseDTO> createUser(UserDTO.UserJoinRequestDTO userJoinRequestDTO) {
        if(this.findUserByEmail(userJoinRequestDTO.getEmail()) != null)
            throw new CustomException(ErrorCode.HAS_EMAIL);

        User user = userJoinRequestDTO.toEntity();
        user.hashPassword(bCryptPasswordEncoder);

        User createdUser = userRepository.save(user);
        return new SuccessResponse<>(true, createdUser.toDTO());
    }

    @Override
    public User findStudentByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'findStudentByEmail'");
    }

    @Override
    public List<User> findStudentAllByName(String name, Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findStudentAllByName'");
    }

    @Override
    public List<StudentDTO> findStudentAllByGrade(Integer grade, Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findStudentAllByGrade'");
    }

    @Override
    public List<StudentDTO> findStudentAllByClassroom(Integer classroom, Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findStudentAllByClassroom'");
    }

    @Override
    public User findStudentById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findStudentById'");
    }

    @Override
    public List<StudentDTO> searchStudentByKeywords(String keyword) {
        throw new UnsupportedOperationException("Unimplemented method 'searchStudentByKeywords'");
    }

    @Override
    public StudentDTO updateStudentByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'updateStudentByEmail'");
    }

    @Override
    public List<TeacherDTO> findAllTeacher() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllTeacher'");
    }

    @Override
    public TeacherDTO findTeacherByName() {
        throw new UnsupportedOperationException("Unimplemented method 'findTeacherByName'");
    }

    @Override
    public TeacherDTO findTeacherByEmail() {
        throw new UnsupportedOperationException("Unimplemented method 'findTeacherByEmail'");
    }

    @Override
    public SuccessResponse<UserDTO.UserLoginResponseDTO> createToken(UserDTO.UserLoginRequestDTO userLoginRequestDTO) {
        User user = this.findUserByEmail(userLoginRequestDTO.getEmail());

        if (user == null) throw new CustomException(ErrorCode.USER_NOT_FOUND);
        if(!user.checkPassword(userLoginRequestDTO.getPassword(), bCryptPasswordEncoder)) throw new CustomException(ErrorCode.INVALID_PASSWORD);

        String token = JwtTokenUtil.createToken(user.getEmail());
        return new SuccessResponse<>(true, new UserDTO.UserLoginResponseDTO(token));
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> user = this.userRepository.findByEmail(email);

        if(user.isEmpty()) return null;
        return user.get();
    }

}
