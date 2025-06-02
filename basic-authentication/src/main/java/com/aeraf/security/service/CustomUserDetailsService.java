package com.aeraf.security.service;

import com.aeraf.security.model.UserPrincipal;
import com.aeraf.security.model.User;
import com.aeraf.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    CustomUserDetailsService(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUserName(username);
        UserDetails userPrincipal = new UserPrincipal(user);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return userPrincipal;
    }

}