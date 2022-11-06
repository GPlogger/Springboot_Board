package com.example.springboard.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
        UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED, 401, "ID나 userName이 중복됩니다.")
    //상태: 클라이언트가 인증되지 않았거나, 유효한 인증 정보가 부족하여 요청이 거부됨
    ;

    private HttpStatus status;
    private int code;
    private String message;

    ErrorCode(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
