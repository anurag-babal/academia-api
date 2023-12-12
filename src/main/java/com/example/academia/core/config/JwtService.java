package com.example.academia.core.config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    
    public String createToken(Authentication authentication) {
        return null;
    }

    public boolean isTokenValid(String token) {
        return false;
    }

    public String getUsername(String token) {
        return null;
    }
}
