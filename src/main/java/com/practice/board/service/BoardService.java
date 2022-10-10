package com.practice.board.service;

import com.practice.board.entity.BOARD;
import com.practice.board.repository.BoardRepositiory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

// 서비스 지정, 서비스는 컨트롤러에서 이용
@Service
// 자동 Bean Container 객체 생성
@RequiredArgsConstructor

public class BoardService {
    // 인터페이스는 객체 생성이 불가능하나 final 사용 시 스프링 빈이 알아서 주입
    private final BoardRepositiory boardRepositiory;

    // 글 작성
    public void write(BOARD board) {    // BOARD 자료형식의 board 받아와서 저장
        boardRepositiory.save(board);
    }
    
    // 게시글 리스트 처리
    public List<BOARD> boardList(){
        // findAll() : DB 내용 전체 반환 >> SELECT * FROM
        return boardRepositiory.findAll();
    }
    
    // 특정 게시글 불러오기
    public BOARD boardView(Integer id) {
        // Entity 에서 ID로 검색해 옵셔널 값을 리턴, get()을 이용해 꺼내 씀(?)
        return boardRepositiory.findById(id).get();
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id) {
        boardRepositiory.deleteById(id);
    }
}
