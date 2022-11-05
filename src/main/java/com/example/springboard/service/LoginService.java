package com.example.springboard.service;

import com.example.springboard.DTO.UserRequestDto;
import com.example.springboard.entity.UserEntity;
import com.example.springboard.error.ErrorCode;
import com.example.springboard.error.exception.LoginErrorException;
import com.example.springboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;

    @Transactional
    public void signUp(UserRequestDto userRequestDto) {
        if(!userRepository.existsByUserId(userRequestDto.getUserId())){
            throw new LoginErrorException("해당 ID는 중복됩니다.", ErrorCode.UNAUTHORIZED_EXCEPTION);
        } else if (userRepository.existsByUserName(userRequestDto.getUserName())){
            throw new LoginErrorException("해당 사용자 명은 이미 사용중입니다.", ErrorCode.UNAUTHORIZED_EXCEPTION);
        }


        UserEntity userEntity = UserEntity.builder()
                .userId(userRequestDto.getUserId())
                .userPw(userRequestDto.getUserPw())
                .userName(userRequestDto.getUserName())
                .build();
        userRepository.save(userEntity);
    }
}