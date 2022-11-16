package com.example.springboard.service;

import com.example.springboard.DTO.BoardDto;
import com.example.springboard.entity.BoardEntity;
import com.example.springboard.entity.UserEntity;
import com.example.springboard.error.ErrorCode;
import com.example.springboard.error.exception.BoardErrorException;
import com.example.springboard.error.exception.LoginErrorException;
import com.example.springboard.repository.BoardRepository;
import com.example.springboard.repository.UserRepository;
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
    private final UserRepository userRepository;

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
    public void add(String user, BoardDto boardDto) {
        UserEntity userEntity = userRepository.findByUserName(user);

        BoardEntity boardEntity = BoardEntity.builder()
                .title(boardDto.getTitle())
                .username(user)
                .content(boardDto.getContent())
                .userEntity(userEntity)
                .build();
        boardRepository.save(boardEntity);
    }

    @Transactional
    public void update(String user,BoardDto boardDto, Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(
                ()->{throw new RuntimeException("해당 번호의 게시물은 없습니다.");});
        if(!user.equals(boardEntity.getUsername())){
            throw new BoardErrorException("해당 요청에 대한 권한이 없습니다.", ErrorCode.FORBIDDEN_EXCEPTION);
        }

        boardEntity.update(boardDto.getTitle(),user, boardDto.getContent());        // 11.14 코드리뷰 : 1차 캐시 저장 후 한번더 저장
//        boardRepository.save(boardEntity);    // 한번 더 세이브하면 업데이트로 들어감(이미 DB 에 있는값과 동일한 값이므로 SELECT 쿼리만 날아감)
    }

    @Transactional
    public void delete(String user, Long id) {        // 삭제
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(
                ()->{throw new RuntimeException("해당 번호의 게시물은 없습니다.");});
        if(!user.equals(boardEntity.getUsername())) {
            throw new BoardErrorException("해당 요청에 대한 권한이 없습니다.", ErrorCode.FORBIDDEN_EXCEPTION);
        }
        boardRepository.delete(boardEntity);    // 11.14 코드리뷰 : delete() 안에 엔티티도 들어감
//        boardRepository.deleteById(id);
    }
}