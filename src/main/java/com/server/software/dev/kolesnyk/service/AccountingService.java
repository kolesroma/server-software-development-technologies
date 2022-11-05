package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.dto.UserDto;
import com.server.software.dev.kolesnyk.entity.AccountingEntity;
import com.server.software.dev.kolesnyk.entity.UserEntity;
import com.server.software.dev.kolesnyk.exception.EntityNotFound;
import com.server.software.dev.kolesnyk.mapper.UserMapper;
import com.server.software.dev.kolesnyk.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDto userDto) {
        userRepository.save(UserMapper.toEntity(userDto));
    }

    public Optional<UserEntity> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public Collection<UserEntity> getAllUsers(Integer page, Integer size) {
        return userRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Transactional
    public void updateUser(UserEntity user, Integer id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFound();
        }
        user.setId(id);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFound();
        }
        userRepository.deleteById(id);
    }
}
