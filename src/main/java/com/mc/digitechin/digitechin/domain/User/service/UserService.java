package com.mc.digitechin.digitechin.domain.User.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.mc.digitechin.digitechin.domain.User.domain.User;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO;
import com.mc.digitechin.digitechin.domain.User.dto.StudentDTO.StudentInfoResponseDTO;
import com.mc.digitechin.digitechin.domain.User.dto.Teacher;
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

    public List<Teacher> findAllTeacher();

    public Teacher findTeacherByName();

    public Teacher findTeacherByEmail();
}
