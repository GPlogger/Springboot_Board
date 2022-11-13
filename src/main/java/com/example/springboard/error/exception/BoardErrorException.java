package com.example.springboard.error.exception;

import com.example.springboard.error.ErrorCode;
import lombok.Getter;

@Getter
public class BoardErrorException extends BusinessException{
    public BoardErrorException(String message, ErrorCode errorCode){
        super(errorCode, message);
    }
}
