package com.example.springboard.error.exception;

import com.example.springboard.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LoginErrorException extends BusinessException{
    public LoginErrorException(String message, ErrorCode errorCode){
        super(errorCode, message);
    }
}