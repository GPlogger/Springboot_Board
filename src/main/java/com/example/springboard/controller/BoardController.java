package com.example.springboard.controller;

import com.example.springboard.DTO.BoardDto;
import com.example.springboard.entity.BoardEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")  // http://localhost:8080/board/  가 기본 경로가 됨(다음에 read, add 등 붙여야 함)
public class BoardController {
    @GetMapping("/read") // 조회 (전체목록)
    public String Get(){
        return "Getall";    // 테스트를 위해 String return

    }

    @PostMapping("/add")  // 생성
    public String Add(@RequestBody BoardDto boardDto){
        // RequestBody : 사용자가 보낸 Json body 를 자동 파싱해주는 역할
        // 사용자가 보낸 Json 양식의 클래스를 설정하고, (@RequestBody 클래스명 객체명) 식으로 사용
        return boardDto.toString();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update/{id}")  // 수정
    public String Update(@RequestBody BoardEntity board, @PathVariable int id){
        // PathVariable : 동적 path 를 수신하는 방법, /update/1 이 요청될 시 {id}를 자동으로 받아옴
        return "Update";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}") // 삭제
    public String Delete(@PathVariable int id){
        return "Delete";
    }
}