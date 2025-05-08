// /src/main/java/com/usermanagement/utils/AuthUtil.java

package com.usermanagement.utils;

import com.usermanagement.core.config.EnvConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {

    private final SecretKey key;
    private final long expirationMs;

    public AuthUtil(EnvConfig config) {
        this.key = Keys.hmacShaKeyFor(config.getJwtSecret().getBytes(StandardCharsets.UTF_8));
        this.expirationMs = config.getJwtExpirationMs();
    }

    public String generateToken(String userId, String email) {
        return Jwts.builder().setSubject(email).claim("user_id", userId).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256).compact();
    }

    public Claims validateToken(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            throw new RuntimeException("Invalid token!", e);
        }
    }

}
