package com.example.springboard.service;

import com.example.springboard.DTO.BoardDto;
import com.example.springboard.entity.BoardEntity;
import com.example.springboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ResourceBundle;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService{
    private final BoardRepository boardRepository;

    public Page<BoardEntity> readAll(Pageable pageable){        // 전체 출력
        return boardRepository.findAll(pageable);
    }

    public BoardEntity readunique(Long id) {     // 단일 출력
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(
                ()->{throw new RuntimeException("해당 정보가 없습니다.");});
        return boardEntity;
    }

    public void add(BoardDto boardDto) {
        BoardEntity boardEntity = boardDto.toEntity();
        boardRepository.save(boardEntity);
    }


    public void delete(int id) {        // 삭제
        boardRepository.deleteById((long) id);
    }
}
