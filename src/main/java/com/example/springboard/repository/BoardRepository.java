package com.example.springboard.repository;

import com.example.springboard.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {   // id 값의 데이터 타입

}
