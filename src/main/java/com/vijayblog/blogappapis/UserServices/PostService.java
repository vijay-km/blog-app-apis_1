package com.vijayblog.blogappapis.UserServices;

import java.util.List;

import com.vijayblog.blogappapis.Payloads.PostDto;

public interface PostService {
    // create


    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    List<PostDto> getAllPost();


    PostDto getPostByID(Integer postId);


    List<PostDto> getPostsByCategory(Integer categoryID);


    List<PostDto> getPostsByUser(Integer UserId);

    List<PostDto> searchPost(String keyword);
}
