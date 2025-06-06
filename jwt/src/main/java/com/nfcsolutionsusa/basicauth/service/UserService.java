package com.nfcsolutionsusa.basicauth.service;

import com.nfcsolutionsusa.basicauth.model.User;
import com.nfcsolutionsusa.basicauth.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    public User register(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);
        user.setPwd(encoder.encode(user.getPwd()));
        userRepo.save(user);
        return user;
    }

    public List<User> listUsers() {
        return userRepo.findAll();
    }

    public String verify(User user) {
        System.out.println("inside verify");
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPwd())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName());
        } else {
            return "fail";
        }
    }
}
