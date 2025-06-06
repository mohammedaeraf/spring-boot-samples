package com.nfcsolutionsusa.basicauth.service;

import com.nfcsolutionsusa.basicauth.model.User;
import com.nfcsolutionsusa.basicauth.model.UserPrincipal;
import com.nfcsolutionsusa.basicauth.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(userName);
        return new UserPrincipal(user);
    }
}
