package com.devmuromi.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 모든 요청이 인증되어야 한다.
        http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
        // 요청이 인증되지 않으면 기본 로그인 페이지로 리다이렉트한다.
        http.httpBasic(withDefaults());
        // CSRF 해제
        http.csrf().disable();

        return http.build();
    }
}
