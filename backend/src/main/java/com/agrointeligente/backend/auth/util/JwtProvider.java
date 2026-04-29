package com.agrointeligente.backend.auth.util;

import com.agrointeligente.backend.auth.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtProvider {

    @Value("${app.jwt.secret:9a8f7c6e5d4f3a2b1c0e9d8f7c6e5d4f3a2b1c0e9d8f7c6e5d4f3a2b1c0e9d}")
    private String jwtSecret;

    @Value("${app.jwt.expiration:86400000}")
    private long jwtExpiration;

    @Value("${app.jwt.refresh-expiration:604800000}")
    private long jwtRefreshExpiration;

    public String generateToken(User user) {
        return generateTokenFromEmail(user.getEmail(), jwtExpiration);
    }

    public String generateRefreshToken(User user) {
        return generateTokenFromEmail(user.getEmail(), jwtRefreshExpiration);
    }

    private String generateTokenFromEmail(String email, long expirationTime) {
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
            .subject(email)
            .issuedAt(new Date())
            .expiration(new Date((new Date()).getTime() + expirationTime))
            .signWith(key)
            .compact();
    }

    public String getEmailFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        Claims claims = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(authToken);
            return true;
        } catch (Exception ex) {
            log.error("Token validacion fallida: {}", ex.getMessage());
            return false;
        }
    }
}
