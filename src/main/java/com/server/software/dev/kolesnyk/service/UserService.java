package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.dto.UserDto;
import com.server.software.dev.kolesnyk.entity.UserEntity;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    void createUser(UserDto userDto);

    Optional<UserEntity> getUser(Integer id);

    Collection<UserEntity> getAllUsers(Integer page, Integer size);

    void updateUser(UserDto userDto, Integer id);

    void deleteUser(Integer id);
}
