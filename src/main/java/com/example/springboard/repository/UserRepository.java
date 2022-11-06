package com.example.springboard.repository;

import com.example.springboard.DTO.UserRequestDto;
import com.example.springboard.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserId(String userId);
    UserEntity findByUserName(String userName);

    boolean existsByUserId(String userId);      // userId 존재 여부 확인
    boolean existsByUserName(String userName);  // userPw 존재 여부 확인
}