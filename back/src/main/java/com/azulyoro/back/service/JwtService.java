package com.azulyoro.back.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.azulyoro.back.model.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String getToken(Employee employee) {
        Map<String, Object> extraClaims = Map.of(
                "name", employee.getName(),
                "lastName", employee.getLastName(),
                "role", employee.getRole());

        return getToken(extraClaims, employee);
    }

    private String getToken(Map<String, Object> extraClaims, Employee employee) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(employee.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getEmailFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, Employee employee) {
        final String email = getEmailFromToken(token);
        return (email.equals(employee.getEmail()) && !isTokenExpired(token));
    }

    // quizas innecesaria
    public List<SimpleGrantedAuthority> getAuthoritiesFromToken(String token) {
        Claims claims = getAllClaims(token);
        String role = claims.get("role", String.class);
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    private Claims getAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private <T> T getClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = getAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }
}
