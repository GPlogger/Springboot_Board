package com.example.springboard.error;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ErrorEntity {
    private int errorCode;
    private String errorMessage;

    @Builder        // 핸들링 부분에서 빌더 필요(리스폰스 엔티티 던지기 위함)
    public ErrorEntity(HttpStatus httpStatus, int errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
