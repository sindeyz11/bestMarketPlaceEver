package com.example.project.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import static com.example.project.entity.Role.ADMIN;
import static com.example.project.entity.Role.MANAGER;
import static com.example.project.entity.Role.USER;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers("/api/v1/auth/**")
                                .permitAll()
                                .requestMatchers(GET, "/api/v1/users/{id}", "/api/v1/orders/user", "/api/v1/product/image/{id}", "/api/v1/product/assortment", "/api/v1/product/categories", "/api/v1/product/special", "/api/v1/points").hasAnyRole(USER.name(), ADMIN.name(), MANAGER.name())
                                .requestMatchers(PATCH, "/api/v1/users/{id}", "/api/v1/users/password", "/api/v1/users/card").hasAnyRole(USER.name(), ADMIN.name(), MANAGER.name())
                                .requestMatchers(POST, "/api/v1/orders").hasAnyRole(USER.name(), ADMIN.name(), MANAGER.name())
                                .requestMatchers(GET, "/api/v1/orders/{id}").hasAnyRole(MANAGER.name())
                                .requestMatchers(PUT, "/api/v1/orders/{id}").hasAnyRole(MANAGER.name())
                                .requestMatchers(GET, "/api/v1/users").hasAnyRole(ADMIN.name())
                                .requestMatchers(POST, "/api/v1/product", "/api/v1/points").hasAnyRole(ADMIN.name())
                                .requestMatchers(PATCH, "/api/v1/product/{id}", "/api/v1/points/{id}").hasAnyRole(ADMIN.name())
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}