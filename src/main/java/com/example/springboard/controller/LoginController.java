package com.example.springboard.controller;

import com.example.springboard.DTO.LoginRequestDto;
import com.example.springboard.DTO.UserRequestDto;
import com.example.springboard.entity.UserEntity;
import com.example.springboard.error.ErrorCode;
import com.example.springboard.error.exception.LoginErrorException;
import com.example.springboard.repository.UserRepository;
import com.example.springboard.service.LoginService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signUp(@RequestBody UserRequestDto userRequestDto){
        return loginService.signUp(userRequestDto);
    }

    @PostMapping("/login")
    public String logIn(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
        // 공백인 경우 에러처리
        if( loginRequestDto.getUserId() == null || loginRequestDto.getUserPw() == null) {
            log.info("입력 란에 공백이 있음");
            throw new LoginErrorException("ID나 비밀번호에 공백이 있습니다.",ErrorCode.NONEXISTENT_INPUT);
        }

        // 에러처리를 컨트롤러 단에서 해 시스템 최적화(서비스로 안넘어감)
        UserEntity userEntity = userRepository.findByUserId(loginRequestDto.getUserId());   // 입력한 ID에 대한 정보 받아옴

        if (userEntity == null) {
            log.info("ID 존재하지 않음");
            throw new LoginErrorException("계정 혹은 비밀번호가 일치하지 않습니다.", ErrorCode.NONEXISTENT_USER );
        } else if ( !passwordEncoder.matches(loginRequestDto.getUserPw(), userEntity.getUserPw())){
            log.info("비밀번호 오류");
            throw new LoginErrorException("계정 혹은 비밀번호가 일치하지 않습니다.", ErrorCode.INVALID_USER);
        }

        return loginService.logIn(userEntity.getUserName(), response);
    }

    @PostMapping("/logout")
    public String logOut(@CookieValue(value = "cookieName", required = true)Cookie cookie, HttpServletResponse response){

        if(cookie == null){
            throw new LoginErrorException("", ErrorCode.NONEXISTENT_COOKIE);
        }
        Cookie temp = new Cookie("cookieName", null);
        temp.setMaxAge(0);
        response.addCookie(temp);

        return "로그아웃 완료";
    }
}