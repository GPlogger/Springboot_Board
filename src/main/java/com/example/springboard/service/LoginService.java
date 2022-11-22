package com.example.springboard.service;

import com.example.springboard.DTO.LoginRequestDto;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class LoginService {
    private final UserRepository userRepository;
    public static final Map<String, String> sessionBox = new HashMap<>();   // static : 공용변수
    private final PasswordEncoder passwordEncoder;      // 사용자의 비밀번호 인코딩을 위해 가져옴

    @Transactional
    public String signUp(UserRequestDto userRequestDto) {
//         에러 처리
        if(userRepository.existsByUserId(userRequestDto.getUserId())){
            log.info("ID 중복");
            throw new LoginErrorException("해당 ID는 중복됩니다.", ErrorCode.UNAUTHORIZED_EXCEPTION);
        } else if (userRepository.existsByUserName(userRequestDto.getUserName())){
            log.info("UserName 중복");
            throw new LoginErrorException("해당 사용자 명은 이미 사용중입니다.", ErrorCode.UNAUTHORIZED_EXCEPTION);
        }

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

    @Transactional
    public String login(String userName, HttpServletResponse response) {
        String session = userName;
        sessionBox.put(session, userName);

        Cookie cookie = new Cookie("cookieName", session);
        cookie.setMaxAge(5*60); // 쿠키 만료 시간 설정(초단위)
        cookie.setPath("/");    // 모든 경로에서 접근 가능하도록 설정 ( / 가 default )
        response.addCookie(cookie); // response 에 쿠키 추가
//        log.info(cookie.getValue());
        return "로그인 완료";
    }
    
}