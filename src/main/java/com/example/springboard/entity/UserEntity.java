package com.example.springboard.entity;

import com.example.springboard.enumcustom.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

}