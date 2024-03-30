package com.mc.digitechin.digitechin.domain.User.constants;

import java.util.Arrays;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Enum UserRole 객체를 데이터베이스와 엔티티 간의 상호작용에 사용할 수 있도록 변환해주는 기능을 담고 있는 객체
 * 
 * @version 1.0.0
 * @since 1.0.0
 * @author yunjisang
 */
@Converter
public class UserRoleConverter implements AttributeConverter<UserRole, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserRole userRole) {
        return userRole.getCodeValue();
    }

    @Override
    public UserRole convertToEntityAttribute(Integer codeValue) {
        return Arrays.stream(UserRole.values()).filter(role -> role.getCodeValue() == codeValue).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
