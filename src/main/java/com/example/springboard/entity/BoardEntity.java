package com.example.springboard.entity;

import lombok.*;

import javax.persistence.*;
// @NoArgsConstructor : 파라미터가 없는 생성자 생성
// @RequiredArgsConstructor : NonNull 인 필드값만 파라미터로 받는 생성자 생성
// @AllArgsConstructor : 모든 필드 값을 파라미터로 받는 생성자 생성
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter  // 접근자를 자동으로 만들어줌 ( getName() {return name;}  ) 식의 접근자를 자동으로 만들어줌
@Builder
@Table(name = "board")
public class BoardEntity {
    @Id
    // 데이터를 저장할 때 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장, strategy 는 고유번호 생성 옵션으로 독립적인 시퀀스 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(length = 1024, nullable = false, columnDefinition = "TEXT")
    private String content;


    public void update(String title_, String username_, String content_) {
        title = title_;
        username = username_;
        content = content_;
    }
}
// private : 변수에 직접 접근해 값을 변경하면 객체지향과 맞지 않음. Getter, Setter 를 사용해 변경할 수 있게 만들어야 함

// 엔티티는 데이터베이스와 바로 연결되어 있으므로 Setter 메서드를 허용하지 않아야 함
// 엔티티 생성 시 롬복의 Builder 어노테이션을 사용하고, 데이터 변경시 그에 해당되는 메서드를 엔티티에 추가하여 데이터 변경
// @Data : Getter, Setter 종합
// @Builder : 빌더 패턴 사용 가능(파라미터가 서로 다를 때, 원하는 파라미터만 넣을 수 있음)