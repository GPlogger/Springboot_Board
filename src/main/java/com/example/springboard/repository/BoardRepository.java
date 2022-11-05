package com.example.springboard.repository;

import com.example.springboard.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {   // id 값의 데이터 타입
    BoardEntity findByTitle(String title);  // findByTitle 추가(pk 값으로만 검색하지 않는 방법)
}