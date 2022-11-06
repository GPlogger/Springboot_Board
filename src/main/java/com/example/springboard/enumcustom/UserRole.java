package com.example.springboard.enumcustom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor    // nonNull 인 필드값만 파라미터로 받음
public enum UserRole {
    // enum 형식 : 리터럴 값 열거형

    // 열거할 목록
    GUEST("ROLE_GUEST", "게스트"),
    USER("ROLE_USER", "사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

    // 열거 목록의 파라미터 값들
    private final String key;
    private final String type;
}
