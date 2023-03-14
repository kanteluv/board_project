package com.seongyun.board.filter;

import com.seongyun.board.security.TokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthencationFilter extends OncePerRequestFilter {
    //request가 들어왔을 때 Request Header에 Authorization 필드의 Bearer 토큰값을 가져온다
    //가져온 토큰을 검증하고 검증결과를 SecurityContext에 추가한다.
    @Autowired private TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            String token = parseBearerToken(request);

            if(token != null && !token.equalsIgnoreCase("null")) {
                //가져오는 토큰값이 널값이 아니거나 대소문자 구분하여 문자열 빈값이 아니라면
                //payload에 유저 이메일값을 가져온다
                String tbUserEmail = tokenProvider.validate(token);

                //SecurityContext에 추가할 객체
                AbstractAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(tbUserEmail, null, AuthorityUtils.NO_AUTHORITIES);

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //SecurityContext에 AbstractAuthenticationToken 객체를 추가하여
                //스레드가 지속적으로 인증 정보를 가질 수 있도록 한다
                //얘는 인터페이스라 바로 선언 안되므로 빈 컨텍스트를 선언하고 채운다
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                securityContext.setAuthentication(authentication);
                //SecurityContextHolder를 이용하여 스레드에서 인증 정보를 계속 가질 수 있도록 함
                SecurityContextHolder.setContext(securityContext);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }

    //Request Header 에서 Authorization 필드의 Bearer 토큰값을 가져오는 메서드
    private String parseBearerToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");

        //hasText 메서드 : string에 null, " " 과 같이 빈 문자열값이면 false, 아니면 true 리턴하는 메서드
        //startWith : 받아오는 문자값이 매개변수처럼 시작하는지 true false 리턴
        //조건 전부 참이면 Bearer (공백포함 총 7칸) 뒤에 값을 리턴시킴
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
            return bearerToken.substring(7);

        return null;
    }
}
