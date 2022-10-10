// entity : 데이터베이스의 테이블에 해당  >> 클라이언트로부터 값을 받고 가공해 DB에 보냄

package com.practice.board.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

// 클래스 이름 위에 Entity 어노테이션 붙이고 멤버변수중 하나를 Id로 지정
@Entity
@Data
@Getter     // get~ 로 받을 수 있음
public class BOARD {
    @Id
    // 데이터를 저장할 때 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장, strategy는 고유번호 생성 옵션으로 독립적인 시퀀스 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // numbering 부여
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    // Column 을 통해 세부적 설정 가능
    @Column(length = 1024, nullable = false, columnDefinition = "TEXT")
    private String content;
}

// 엔티티는 데이터베이스와 바로 연결되어 있으므로 Setter 메서드를 허용하지 않아야 함
// 엔티티 생성 시 롬복의 Builder 어노테이션을 사용하고, 데이터 변경시 그에 해당되는 메서드를 엔티티에 추가하여 데이터 변경