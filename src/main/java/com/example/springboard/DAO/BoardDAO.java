package com.example.springboard.DAO;

import com.example.springboard.entity.BoardEntity;

public class BoardDAO {
    BoardEntity saveBoard(BoardEntity boardEntity);

    BoardEntity getBoard(Long id);
}
