package com.example.academia.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.academia.login.data.LoginRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  // private final JwtAuthenticationFilter jwtAuthenticationFilter;
  private final LoginRepository loginRepository;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(configurer -> configurer
            .requestMatchers("/api/v1", "/api/login").permitAll()
            .requestMatchers("/api/v1/employees/**").hasRole("FACULTY")
            .anyRequest().authenticated());
    
    // Use HTTP Basic Authentication
    http.httpBasic(Customizer.withDefaults());

    // Disable Cross Site Request Forgery (CSRF)
    http.csrf(csrf -> csrf.disable());

    http.authenticationProvider(authenticationProvider());
    // .sessionManagement(sessionManagement -> sessionManagement
    // .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    // .addFilterBefore(jwtAuthenticationFilter,
    // UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  // @Bean
  // public InMemoryUserDetailsManager userDetailsManager() {
  //   UserDetails user = User.builder()
  //       .username("user")
  //       .password("{noop}pass")
  //       .roles("USER")
  //       .build();
  //   return new InMemoryUserDetailsManager(user);
  // }

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> loginRepository.getUserByUsername(username);
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // @Bean
  // public AuthenticationManager
  // authenticationManager(AuthenticationConfiguration configuration) throws
  // Exception {
  // return configuration.getAuthenticationManager();
  // }
}
