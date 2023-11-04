package com.vijayblog.blogappapis.Rpositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayblog.blogappapis.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{
    
}
