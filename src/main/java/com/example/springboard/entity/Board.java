package com.example.springboard.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter  // 접근자를 자동으로 만들어줌 ( getName() {return name;}  ) 식의 접근자를 자동으로 만들어줌
public class Board {
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
}
