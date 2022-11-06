package com.example.springboard.error;

import com.example.springboard.error.exception.LoginErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
//@ControllerAdvice : 모든 컨트롤러에 대해 전역적으로 발생할 수 있는 예외를 잡아서 처리 가능


@RequiredArgsConstructor
@RestControllerAdvice // 에러 처리 핸들링, @ResponseBode 를 통해 객체를 리턴할 수 있음 (응답으로 객체를 리턴)
public class ErrorExceptionControllerAdvice {


    @ExceptionHandler({LoginErrorException.class})  // LoginErrorException.class 를 지정
    public ResponseEntity<ErrorEntity> exceptionHandler(HttpServletRequest request, final LoginErrorException e){
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(ErrorEntity.builder()
                        .errorCode(e.getErrorCode().getCode())
                        .errorMessage(e.getErrorCode().getMessage())
                        .build());
    }
}