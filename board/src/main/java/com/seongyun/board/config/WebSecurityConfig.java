package com.seongyun.board.config;

import com.seongyun.board.filter.JwtAuthencationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired JwtAuthencationFilter jwtAuthencationFilter;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //CORS 정책 (현재는 어플리케이션에서 작업을 해뒀으므로 기본 설정을 사용중
                .cors().and()
                //CSRF 정책에 대한 대책을 비활성화 시킴
                .csrf().disable()
                //Basic 인증을 지금 Bearer 토큰 인증방법을 사용하므로 비활성화 시킴
                .httpBasic().disable()
                //세션 기반 인증 방식 사용에 대한 내용 : 지금 사용하지 않으므로 비활성화 상태로 설정
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // '/', '/api/aut' 에 대해서는 인증을 하지않고 사용 가능하게 허용
                .authorizeHttpRequests().requestMatchers("/", "/api/auth/**").permitAll()
                // 나머지 request 에 대해서는 모두 인증된 사용자만 사용가능하게 함
                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(jwtAuthencationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
