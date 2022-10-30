package com.example.springboard.service;

import com.example.springboard.DTO.BoardDto;
import com.example.springboard.entity.BoardEntity;
import com.example.springboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService{
    private final BoardRepository boardRepository;

    public Page<BoardEntity> readAll(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public void add(BoardDto boardDto) {
        BoardEntity boardEntity = boardDto.toEntity();
        boardRepository.save(boardEntity);

    }

}
