package com.aeraf.security.config;

import com.aeraf.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.userDetailsService);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(customizer -> customizer.disable());

        httpSecurity.authorizeHttpRequests(
                auth -> auth.requestMatchers("/greetings").permitAll()
        );

        httpSecurity.authorizeHttpRequests(
                auth -> auth.requestMatchers(HttpMethod.POST, "/users").permitAll()
        );

        httpSecurity.authorizeHttpRequests(
                auth -> auth.requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
        );

        httpSecurity.authorizeHttpRequests(
                authorize -> authorize.requestMatchers("/secured").hasAnyRole("SITEUSER")
        );
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("/admin-logs").hasRole("ADMIN"));

        httpSecurity.httpBasic(Customizer.withDefaults()); // Basic Authentication

        return httpSecurity.build();
    }


}
