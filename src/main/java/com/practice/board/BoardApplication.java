// 닉네임, 제목, 내용 받아서 저장, 수정, 삭제, 조회 가능 게시판 만들기
package com.practice.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
		System.out.println("——————————————Server boot Complete——————————————");


	}

}


// RequestMapping : 어떤 HTTP 메소드와 URL로 요청 받을지 정의