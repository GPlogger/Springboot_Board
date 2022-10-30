// DTO : key와 value 가 정해져 있을 때 사용 (Get, Set, toString 메서드 등 사용)
//
package com.example.springboard.DTO;

import com.example.springboard.entity.BoardEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {
    private String title;
    private String username;
    private String content;


    public BoardEntity toEntity(){         // DTO 에서 Entity 로 보냄(보안)
        BoardEntity boardEntity = BoardEntity.builder()     // builder 사용 ( builder 와 build 사이에 값 넣음)
                .title(title)
                .username(username)
                .content(content)
                .build();
        return boardEntity;
    }
}
// toEntity 작성 > 호출 > DB 작성
// repository.save > entity 삽입