package com.server.software.dev.kolesnyk.mapper;

import com.server.software.dev.kolesnyk.dto.UserDto;
import com.server.software.dev.kolesnyk.entity.AccountingEntity;
import com.server.software.dev.kolesnyk.entity.UserEntity;

public class UserMapper {
    public static UserEntity toEntity(UserDto userDto) {
        return UserEntity.builder()
                .name(userDto.getName())
                .accounting(AccountingEntity.builder().balance(userDto.getBalance()).build())
                .build();
    }
}
