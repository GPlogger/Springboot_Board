package com.example.springboard.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    // 사용자가 ID나 PW를 입력하지 않았을 때
    NONEXISTENT_INPUT(HttpStatus.BAD_REQUEST, 0, "ID나 비밀번호를 입력하세요."),
    // 사용자가 입력한 ID의 userName 이 없을 때
    NONEXISTENT_USER(HttpStatus.BAD_REQUEST, 1, "해당 계정이 존재하지 않습니다."),
    // 쿠키가 없음
    NONEXISTENT_COOKIE(HttpStatus.BAD_REQUEST, 2, "쿠키가 존재하지 않습니다."),
    INVALID_USER(HttpStatus.UNAUTHORIZED, 3, "아이디 또는 비밀번호가 일치하지 않습니다."),
    UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED, 4, "ID나 userName이 중복됩니다."),
    UNAUTHORIZED_NONE_LOGIN(HttpStatus.UNAUTHORIZED, 401, "로그인되어있지 않습니다."),
    //상태: 클라이언트가 인증되지 않았거나, 유효한 인증 정보가 부족하여 요청이 거부됨
    FORBIDDEN_EXCEPTION(HttpStatus.FORBIDDEN, 403, "해당 요청에 대한 권한이 없습니다.")
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
