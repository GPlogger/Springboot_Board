// DTO : key와 value 가 정해져 있을 때 사용 (Get, Set, toString 메서드 등 사용)
//
package com.example.springboard.DTO;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {
    private long id;
    private String title;
    private String username;
    private String content;

}
