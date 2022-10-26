package com.example.springboard.controller;

import com.example.springboard.entity.Board;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {
    @RequestMapping(method = RequestMethod.GET, path = "/board") // 조회 (전체목록)
    public String Get(){
        return "Getall";    // 테스트를 위해 String return

    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")  // 생성
    public String Add(@RequestBody Board board){
        // RequestBody : 사용자가 보낸 Json body 를 자동 파싱해주는 역할
        // 사용자가 보낸 Json 양식의 클래스를 설정하고, (@RequestBody 클래스명 객체명) 식으로 사용
        return "add";
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update/{id}")  // 수정
    public String Update(@RequestBody Board board, @PathVariable int id){
        // PathVariable : 동적 path 를 수신하는 방법, /update/1 이 요청될 시 {id}를 자동으로 받아옴
        return "Update";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}") // 삭제
    public String Delete(@PathVariable int id){
        return "Delete";
    }
}