package com.vijayblog.blogappapis.Rpositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayblog.blogappapis.Entities.Category;
import com.vijayblog.blogappapis.Entities.Post;
import com.vijayblog.blogappapis.Entities.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
    

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
