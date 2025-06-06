package com.nfcsolutionsusa.basicauth.repository;

import com.nfcsolutionsusa.basicauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
