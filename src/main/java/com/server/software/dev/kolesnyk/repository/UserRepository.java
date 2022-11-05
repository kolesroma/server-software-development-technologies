package com.server.software.dev.kolesnyk.repository;

import com.server.software.dev.kolesnyk.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
}
