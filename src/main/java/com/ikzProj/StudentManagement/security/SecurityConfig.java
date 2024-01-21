package com.ikzProj.StudentManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(csrf->csrf.disable())
                .authorizeRequests(authorizeRequest->authorizeRequest.anyRequest().permitAll())
                .build();
//                .authorizeHttpRequests((auth)->auth.requestMatchers(HttpMethod.POST,"/api/v1/student").hasAnyRole("ADMIN","USER")
//                        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                ).sessionManagement((session)->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin = User.builder()
                .username("admin")
                .password("adminPass")
                .roles("ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("user")
                .password("userPass")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }




}



