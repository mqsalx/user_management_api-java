// /src/main/java/com/usermanagement/core/middlewares/auth/AuthMiddleware.java

package com.usermanagement.core.middlewares.auth;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.usermanagement.utils.AuthUtil;
import com.usermanagement.utils.ResponseUtil;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthMiddleware extends OncePerRequestFilter {

    private final AuthUtil authUtil;
    private final ResponseUtil responseUtil;

    public AuthMiddleware(AuthUtil authUtil, ResponseUtil responseUtil) {
        this.authUtil = authUtil;
        this.responseUtil = responseUtil;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();
        List<String> publicPaths = List.of("/api/auth");

        if (publicPaths.stream().anyMatch(path::startsWith)) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            responseUtil.filterJsonResponse(response, HttpStatus.UNAUTHORIZED,
                    "Missing or invalid Authorization header!");
            return;
        }

        String token = authHeader.substring(7);
        try {
            Claims claims = authUtil.validateToken(token);
            request.setAttribute("userEmail", claims.getSubject());
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            responseUtil.filterJsonResponse(response, HttpStatus.UNAUTHORIZED, "Invalid or expired token!");
        }
    }
}
