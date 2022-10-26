package com.example.springboard.DAO.impl;

import com.example.springboard.entity.BoardEntity;
import com.example.springboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDAOImpl {
    BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Override
    public BoardEntity saveBoard(BoardRepository boardRepository){
        boardRepository.save(BoardEntity);
        return boardRepository;
    }
}
