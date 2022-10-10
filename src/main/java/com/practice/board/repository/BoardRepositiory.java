package com.practice.board.repository;

import com.practice.board.entity.BOARD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 레포지터리 지정 (interface 로 만들음)
public interface BoardRepositiory extends JpaRepository<BOARD, Integer> {   // JpaRepository 상속받음 <받을 엔티티, 엔티티의 타입>

}
