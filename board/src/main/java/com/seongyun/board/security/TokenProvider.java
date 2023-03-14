package com.seongyun.board.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//JWT : 전자서명 된 토큰
//JSON 형태로 구성되어있다
// {header}.{payload}.{signature} 으로 구성되어 있다
// header: typ (해당토큰의 타입), alg (토큰을 서명하기 위해 필요한 해시 알고리즘)
// payload: sub (해당토큰의 주인), iat(토큰이 발행된 시간), exp(토큰이 만료되는 시간)
// 추가로 들어가는 요소들도 있지만 기본적인 값들임

@Service
public class TokenProvider {
    //JWT 생성 및 검증을 위한 키
    private static final String SECURITY_KEY = "jwtsecuritykey!@";

    //JWT 생성하는 메서드
    public String create (String userEmail) {
        //만료기한 현재 시간 + 1시간으로 설정
        Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
        System.out.println(exprTime);
        //JWT 생성
        return Jwts.builder()
                .setSubject(userEmail)
                .setIssuedAt(new Date())
                .setExpiration(exprTime)
                .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
                .compact();
//                //암호화 알고리즘, 키값 받아옴
//                .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
//                //JWT 토큰 제목, 생성일, 만료일 셋팅
//                .setSubject(userEmail).setIssuedAt(new Date()).setExpiration(exprTime)
//                //해당 함수로 생성
//                .compact();
    }

    public String validate (String token) {
        //매개변수로 받은 token을 키를 이용하여 복호화(디코딩)
        Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
        //복호화된 토큰의 payload에서 제목을 가져온다
        return claims.getSubject();
    }
}
