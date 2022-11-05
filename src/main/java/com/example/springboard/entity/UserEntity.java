package com.example.springboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Cleanup;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)   // unique : 중복 되면 안됨
    private String userId;

    @Column(nullable = false, length = 64)
    private String userPw;

    @Column(nullable = false, length = 10, unique = true)
    private String userName;

}