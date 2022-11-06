package com.example.springboard.DTO;

import com.example.springboard.entity.UserEntity;
import com.example.springboard.enumcustom.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequestDto {   // post, put : request ( 로컬에서 DB로 요청 보냄 )

    private String userId;
    private String userPw;
    private String userName;
    private UserRole userRole;

//    public UserEntity toEntity(){
//        UserEntity userEntity = UserEntity.builder()
//                .userId(userId)
//                .userPw(userPw)
//                .userName(userName)
//                .userRole(UserRole.USER)
//                .build();
//
//        return userEntity;
//    }


}
