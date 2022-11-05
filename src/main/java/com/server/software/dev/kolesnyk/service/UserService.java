package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.dto.UserDto;
import com.server.software.dev.kolesnyk.entity.UserEntity;
import com.server.software.dev.kolesnyk.exception.EntityNotFound;
import com.server.software.dev.kolesnyk.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AccountingService accountingService;

    public UserService(UserRepository userRepository, AccountingService accountingService) {
        this.userRepository = userRepository;
        this.accountingService = accountingService;
    }

    @Transactional
    public void createUser(UserDto userDto) {
        UserEntity user = UserEntity.builder()
                .name(userDto.getName())
                .accounting(accountingService.saveAccounting(userDto.getBalance()))
                .build();
        userRepository.save(user);
    }

    public Optional<UserEntity> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public Collection<UserEntity> getAllUsers(Integer page, Integer size) {
        return userRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Transactional
    public void updateUser(UserDto userDto, Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(EntityNotFound::new);
        user.setName(userDto.getName());
        user.getAccounting().setBalance(userDto.getBalance());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(EntityNotFound::new);
        accountingService.deleteAccounting(user.getAccounting().getId());
    }
}
