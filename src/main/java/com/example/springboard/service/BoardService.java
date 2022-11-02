package com.example.springboard.service;

import com.example.springboard.DTO.BoardDto;
import com.example.springboard.entity.BoardEntity;
import com.example.springboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService{
    private final BoardRepository boardRepository;

    @Transactional
    public List<BoardEntity> readAll(){        // 전체 출력
        return boardRepository.findAll();
    }       // 페이지 형식이 필요 없음, 리턴 필요 없음 ( findAll 실행 시 Response 에 자동으로 날아감 )
    @Transactional
    public BoardEntity getFindOne(Long id) {     // 단일 출력
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(     // 예외처리 하지 않으면 오류
                ()->{throw new RuntimeException("해당 번호의 게시물은 없습니다.");});
        return boardEntity;
    }

    @Transactional
    public void add(BoardDto boardDto) {
        BoardEntity boardEntity = BoardEntity.builder()
                .title(boardDto.getTitle())
                .username(boardDto.getUsername())
                .content(boardDto.getContent())
                .build();
        boardRepository.save(boardEntity);
    }

    @Transactional
    public void update(BoardDto boardDto, Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(
                ()->{throw new RuntimeException("해당 번호의 게시물은 없습니다.");});
        boardEntity.update(boardDto.getTitle(), boardDto.getUsername(), boardDto.getContent());       // 엔티티에 업데이트 함수 작성 필요
        boardRepository.save(boardEntity);
    }

    @Transactional
    public void delete(Long id) {        // 삭제
        boardRepository.deleteById(id);
    }


}
