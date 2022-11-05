package com.example.springboard.error.exception;

import com.example.springboard.error.ErrorCode;
import lombok.Getter;

// 시스템 오류가 아닌 로직에서 발생한 예외를 처리할 때 사용
@Getter
public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;      // 시간이 지나도 처음 정의된 상태가 변하지 않음( const )

    public BusinessException(ErrorCode errorCode, String message) {
        super(message); // 자식 클래스가 부모 클래스
        this.errorCode = errorCode;
    }
}
