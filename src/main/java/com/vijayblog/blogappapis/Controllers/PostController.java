package com.vijayblog.blogappapis.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijayblog.blogappapis.Payloads.ApiResponse;
import com.vijayblog.blogappapis.Payloads.PostDto;
import com.vijayblog.blogappapis.UserServices.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
        @RequestBody PostDto postDto,
        @PathVariable Integer userId,
        @PathVariable Integer categoryId
        )
    {
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);

        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    // get posts By User
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(
        @PathVariable Integer userId
        )
    {
        List<PostDto> postByUser = this.postService.getPostsByUser(userId);

        return new ResponseEntity<List<PostDto>>(postByUser,HttpStatus.OK);
    }

    //// get posts By Category

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(
        @PathVariable Integer categoryId
        )
    {
        List<PostDto> postByCategory = this.postService.getPostsByCategory(categoryId);

        return new ResponseEntity<List<PostDto>>(postByCategory,HttpStatus.OK);
    }

    // get all posts

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> postDtos = this.postService.getAllPost();
        return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostByID(@PathVariable Integer postId){
        PostDto postDto = this.postService.getPostByID(postId);

        return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
    }

    // delete post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("Post Successfully Deleted", true);

    }
    // update post

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto postDto2 = this.postService.updatePost(postDto, postId);

        return new ResponseEntity<PostDto>(postDto2,HttpStatus.OK);
    }
}
