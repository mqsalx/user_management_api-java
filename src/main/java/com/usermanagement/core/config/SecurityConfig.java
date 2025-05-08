package com.usermanagement.core.config;

import com.usermanagement.core.middlewares.auth.AuthMiddleware;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthMiddleware authMiddleware) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .httpBasic(httpBasic -> httpBasic.disable())
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(this::isBrowserRequest).denyAll()
                .anyRequest().permitAll()
            )
            .addFilterBefore(authMiddleware, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



    private boolean isBrowserRequest(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return userAgent != null && (userAgent.contains("Mozilla") || userAgent.contains("Chrome")
                || userAgent.contains("Safari") || userAgent.contains("Firefox") || userAgent.contains("Edge"));
    }
}
