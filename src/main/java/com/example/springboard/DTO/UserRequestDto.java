package com.example.springboard.DTO;

import com.example.springboard.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDto {   // post, put : request ( 로컬에서 DB로 요청 보냄 )
    private String userId;
    private String userPw;
    private String userName;

    public UserEntity toEntity(){
        UserEntity userEntity = UserEntity.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .build();

        return userEntity;
    }


}
