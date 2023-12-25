package com.example.academia.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  private final AuthenticationProvider authenticationProvider;
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // Disable Cross Site Request Forgery (CSRF)
    http.csrf(csrf -> csrf.disable());

    // Disable Cross-Origin Resource Sharing (CORS)
    http.cors(cors -> cors.disable());

    // Enable SSL
    http.requiresChannel(channel -> channel.anyRequest().requiresSecure());

    http.authorizeHttpRequests(configurer -> configurer
        .requestMatchers("/api/v1/authenticate", "/api/v1/register").permitAll()
        .requestMatchers("/api/v1/employees/**").hasRole("EMPLOYEE")
        .requestMatchers("/api/v1/students/**").hasAnyRole("ADMIN", "STUDENT")
        .anyRequest().authenticated());

    http.authenticationProvider(authenticationProvider);

    http.sessionManagement(
        sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
