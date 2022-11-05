package com.example.springboard.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002", "401 UnAuthorized")
    //상태: 클라이언트가 인증되지 않았거나, 유효한 인증 정보가 부족하여 요청이 거부됨
    ;

    private HttpStatus status;
    private String code;
    private String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
