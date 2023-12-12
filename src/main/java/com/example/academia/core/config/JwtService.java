package com.example.academia.core.config;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.academia.login.domain.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

  @Value("${academia.jwt.secret}")
  private String jwtSecret;

  @Value("${academia.jwt.expirationInMs}")
  private int jwtExpirationMs;

  public String createToken(Authentication authentication) {
    User user = (User) authentication.getPrincipal();
    return Jwts.builder()
        .setSubject(user.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
        .signWith(getSignKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public String getUsername(String token) {
    return extractUsername(token);
  }

  public boolean isTokenValid(String token) {
    return isTokenExpired(token);
  }

  private Key getSignKey() {
    byte[] key = Decoders.BASE64.decode(jwtSecret);
    return Keys.hmacShaKeyFor(key);
  }

  private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSignKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
    final Claims claims = extractAllClaims(token);
    return claimResolver.apply(claims);
  }

  private String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }
}
