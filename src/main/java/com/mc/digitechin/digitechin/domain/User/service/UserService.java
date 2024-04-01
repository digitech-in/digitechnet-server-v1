package com.mc.digitechin.digitechin.domain.User.service;

import com.mc.digitechin.digitechin.domain.User.dto.BaseUser;
import com.mc.digitechin.digitechin.domain.User.dto.Student;

public interface UserService {
    public BaseUser findUserByEmail();

    public BaseUser findUserByName();

    public Student findStudentByEmail();

    public Student findStudentByName();
}
