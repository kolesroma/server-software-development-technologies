package com.server.software.dev.kolesnyk.service.impl;

import com.server.software.dev.kolesnyk.dto.UserDto;
import com.server.software.dev.kolesnyk.entity.UserEntity;
import com.server.software.dev.kolesnyk.exception.UserNotFound;
import com.server.software.dev.kolesnyk.repository.UserRepository;
import com.server.software.dev.kolesnyk.service.AccountingService;
import com.server.software.dev.kolesnyk.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountingService accountingService;

    public UserServiceImpl(UserRepository userRepository, com.server.software.dev.kolesnyk.service.AccountingService accountingService) {
        this.userRepository = userRepository;
        this.accountingService = accountingService;
    }

    @Override
    public void createUser(UserDto userDto) {
        UserEntity user = UserEntity.builder()
                .name(userDto.getName())
                .accounting(accountingService.saveAccounting(userDto.getBalance()))
                .build();
        userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> getUser(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Collection<UserEntity> getAllUsers(Integer page, Integer size) {
        return userRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Override
    @Transactional
    public void updateUser(UserDto userDto, Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);
        user.setName(userDto.getName());
        user.getAccounting().setBalance(userDto.getBalance());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);
        accountingService.deleteAccounting(user.getAccounting().getId());
    }
}
