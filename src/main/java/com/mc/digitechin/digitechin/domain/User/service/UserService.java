package com.mc.digitechin.digitechin.domain.User.service;

import java.util.List;

import com.mc.digitechin.digitechin.domain.User.dto.TeacherDTO;
import com.mc.digitechin.digitechin.domain.User.dto.UserDTO;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.mc.digitechin.digitechin.domain.User.domain.User;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO.StudentInfoResponseDTO;
import com.mc.digitechin.digitechin.global.common.SuccessResponse;

public interface UserService {
    /**
     * 모든 학생 데이터를 페이징해 리턴
     *
     * @Todo 필터링을 통한 검색
     * @return Page<Student>
     * @throws NotFoundException
     */
    public SuccessResponse<List<StudentInfoResponseDTO>> findAllStudent(@PageableDefault(size = 10) Pageable pageable)
            throws NotFoundException;

    /**
     * 유저를 DB에 등록하고 id, name, email을 SuccessResponse 객체에 담아 리턴
     *
     * @return SuccessResponse<UserDTO.UserJoinResponseDTO>
     */
    public SuccessResponse<UserDTO.UserJoinResponseDTO> createUser(UserDTO.UserJoinRequestDTO userJoinRequestDTO);

    /**
     * 입력된 이메일을 가지고 있는 학생 데이터를 리턴
     * 
     * @param email 사용자가 입력한 이메일
     * @return Student
     */
    public User findStudentByEmail(String email);

    /**
     * 입력된 이름과 같은 학생 데이터를 리턴
     * 
     * @param name 사용자가 입력한 이름
     * @return Page<Student>
     */
    public List<User> findStudentAllByName(String name, Pageable pageable);

    /**
     * 입력된 학년에 소속된 학생 데이터를 페이징해 리턴
     * 
     * @param grade 사용자가 입력한 학년
     * @return Page<Student>
     */
    public List<StudentDTO> findStudentAllByGrade(Integer grade, Pageable pageable);

    /**
     * 입력된 반에 소속된 학생 데이터를 페이징해 리턴
     * 
     * @param classroom 사용자가 입력한 반
     * @return Page<Student>
     */
    public List<StudentDTO> findStudentAllByClassroom(Integer classroom, Pageable pageable);

    /**
     * 데이터베이스에 저장된 유니크한 아이디를 통해 학생을 찾아 리턴
     * 
     * @param id 아이디
     * @return Student
     */
    public User findStudentById(Integer id);

    /**
     * 검색 시 입력된 키워드와 일치하는 학생 데이터를 찾아 리턴
     * 
     * @param keyword 입력된 키워드
     * @return Page<Student>
     */
    public List<StudentDTO> searchStudentByKeywords(String keyword);

    /**
     * 학생 데이터 업데이트
     * 
     * @param email 토큰에서 추출한 이메일
     * @return Student 업데이트된 학생 데이터
     */
    public StudentDTO updateStudentByEmail(String email);

    public List<TeacherDTO> findAllTeacher();

    public TeacherDTO findTeacherByName();

    public TeacherDTO findTeacherByEmail();

    /**
     * 인자로 넘어온 이메일을 통해 유저를 검색한 후 토큰을 만들어 리턴
     * @param userLoginRequestDTO
     * @return SuccessResponse<UserDTO.UserLoginResponseDTO>
     */
    public SuccessResponse<UserDTO.UserLoginResponseDTO> createToken(UserDTO.UserLoginRequestDTO userLoginRequestDTO);

    /**
     * 인자로 넘어온 이메일을 통해 유저를 검색한 후 있다면 User, 없다면 null 반환
     * @param email
     * @return
     */
    public User findUserByEmail(String email);
}
