package com.example.springboard.controller;

import com.example.springboard.DTO.UserRequestDto;
import com.example.springboard.repository.UserRepository;
import com.example.springboard.service.LoginService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public String signUp(@RequestBody UserRequestDto userRequestDto){
        return loginService.signUp(userRequestDto);
    }

}