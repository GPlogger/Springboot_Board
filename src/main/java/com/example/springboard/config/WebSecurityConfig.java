package com.example.springboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // 가시적 설정파일
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean // 수동으로 빈 설정 : 해당 메서드의 이름이 빈의 이름이 됨
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // 비크립트 인코더 사용
        // 내장 메서드 사용법
        // .encode > 패스워드를 8바이트 해쉬로 암호화, 반환타입 String, 똑같은 비밀번호라도 매번 다른 인코딩 된 문자열로 반화됨
        // .matchers > (유저 입력 패스워드, 인코딩된 패스워드)의 일치 여부 확인, 반환타입 boolean
        // .upgradeEncoding > 인코딩을 두번 함
    }

    @Override   // protected : 상속 받은 것 끼리만 사용하겠다(부모 관계에서만 사용, 외부에서 사용 x)
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors().disable()
                .csrf().disable() // csrf 기능 미사용
                .formLogin().disable() // 기본 로그왼 화면 미사용
                .headers().frameOptions().disable(); // HTTP 통신의 헤더 설정. iframe 설정 미사용


        httpSecurity.sessionManagement(
                s->s.sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // 항상 세션 생성
                        .sessionFixation(sessionFixationConfigurer -> sessionFixationConfigurer.changeSessionId())// 인증 시 새로운 세션 발급
                        .maximumSessions(1) // 인증시 새로운 세션아이디 발급
                        .maxSessionsPreventsLogin(true) // 동일 계정 로그인 시 기존 세션 만료(동시접속제한)
        );
    }
}
