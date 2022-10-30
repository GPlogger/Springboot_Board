package com.example.springboard.controller;

import com.example.springboard.DTO.BoardDto;
import com.example.springboard.entity.BoardEntity;
import com.example.springboard.repository.BoardRepository;
import com.example.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // Autowired 기능 대신함
@Slf4j
@RequestMapping("/board")  // http://localhost:8080/board/  가 기본 경로가 됨(다음에 read, add 등 붙여야 함)
public class BoardController {
    private final BoardService boardService;    // 상속 불가능, board 레퍼지토리에 직접적인 영향이 가지 않게 함

    @GetMapping("/read") // 조회 (전체목록)
    public Page<BoardEntity> Get(Pageable pageable){
        return boardService.readAll(pageable);
    }

    @GetMapping("/readunique/{id}") // 조회 (단일목록)
    public BoardEntity readunique(@PathVariable Long id){
        return boardService.readunique(id);
    }

    @PostMapping("/add")  // 생성            DB 넣는 과정 컨트롤러 > DTO 형식 > 서비스 > 엔티티형식 만들고 DTO 의 toEntity 사용 > 엔티티형식을 레퍼지토리에 세이브
    public void Add(@RequestBody BoardDto boardDto){
        // RequestBody : 사용자가 보낸 Json body 를 자동 파싱해주는 역할
        // 사용자가 보낸 Json 양식의 클래스를 설정하고, (@RequestBody 클래스명 객체명) 식으로 사용
        boardService.add(boardDto);
    }

    @PutMapping("/update/{id}")  // 수정
    public BoardEntity Update(@RequestBody BoardDto boardDto, @PathVariable Long id){
        // PathVariable : 동적 path 를 수신하는 방법, /update/1 이 요청될 시 {id}를 자동으로 받아옴
        boardService.update(boardDto, id);
        return boardService.readunique(id);
    }

    @DeleteMapping("/delete/{id}") // 삭제
    public void Delete(@PathVariable Long id){
        boardService.delete(id);
    }
}