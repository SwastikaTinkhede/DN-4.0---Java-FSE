package com.cognizant.spring_learn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder.encode("pwd")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder.encode("pwd")).roles("USER")
                .and()
                .and().build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        http.csrf().disable()
            .httpBasic()
            .and()
            .authorizeRequests()
            .requestMatchers("/authenticate").hasAnyRole("ADMIN", "USER")
            .requestMatchers("/hello").authenticated()
            .anyRequest().authenticated()
            .and()
            .addFilter(new JwtAuthorizationFilter(authManager));

        return http.build();
    }
}

