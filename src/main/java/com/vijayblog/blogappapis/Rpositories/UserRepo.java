package com.vijayblog.blogappapis.Rpositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayblog.blogappapis.Entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    
}
