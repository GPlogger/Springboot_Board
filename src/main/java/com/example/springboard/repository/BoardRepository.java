package com.example.springboard.repository;

import com.example.springboard.entity.BoardEntity;
import com.example.springboard.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {   // id 값의 데이터 타입
    BoardEntity findByTitle(String title);  // findByTitle 추가(pk 값으로만 검색하지 않는 방법)

    List<BoardEntity> findByUserEntity(UserEntity userEntity);  // 하나만 나오는게 아니니까 List 형식으로 받음

    @Query("SELECT b From BoardEntity b join fetch b.userEntity WHERE b.userEntity.userName = :userName")
    // 받아온 userName으로 boardEntity에서 userEntity의
    //join fetch : FETCH LAZY 사용    테이블 명 대신 엔티티 명 사용
    public List<BoardEntity> findAllbyUserEntity(@Param("userName")String userName);
}