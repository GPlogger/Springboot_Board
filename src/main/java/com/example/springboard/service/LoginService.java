package com.example.springboard.service;

import com.example.springboard.DTO.UserRequestDto;
import com.example.springboard.entity.UserEntity;
import com.example.springboard.enumcustom.UserRole;
import com.example.springboard.error.ErrorCode;
import com.example.springboard.error.exception.LoginErrorException;
import com.example.springboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class LoginService {
    private final UserRepository userRepository;
    private final Map<String, Object> sessionBox = new HashMap<>();
    private final PasswordEncoder passwordEncoder;      // 사용자의 비밀번호 인코딩을 위해 가져옴

    @Transactional
    public String signUp(UserRequestDto userRequestDto) {
        // 에러 처리
//        if(userRepository.existsByUserId(userRequestDto.getUserId())){
//            log.info("ID 중복");
//            throw new LoginErrorException("해당 ID는 중복됩니다.", ErrorCode.UNAUTHORIZED_EXCEPTION);
//        } else if (userRepository.existsByUserName(userRequestDto.getUserName())){
//            log.info("UserName 중복");
//            throw new LoginErrorException("해당 사용자 명은 이미 사용중입니다.", ErrorCode.UNAUTHORIZED_EXCEPTION);
//        }

//
        String encodedPw = passwordEncoder.encode(userRequestDto.getUserPw());  // pw 인코딩

        UserEntity userEntity = UserEntity.builder()
                .userId(userRequestDto.getUserId())
                .userPw(encodedPw)
                .userName(userRequestDto.getUserName())
                .userRole(UserRole.USER)
                .build();
        userRepository.save(userEntity);
        return "회원가입 완료";
    }


}