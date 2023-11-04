package com.vijayblog.blogappapis.UserServices.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijayblog.blogappapis.Entities.Category;
import com.vijayblog.blogappapis.Entities.Post;
import com.vijayblog.blogappapis.Entities.User;
import com.vijayblog.blogappapis.Exceptions.ResourceNotFoundException;
import com.vijayblog.blogappapis.Payloads.PostDto;
import com.vijayblog.blogappapis.Rpositories.CategoryRepo;
import com.vijayblog.blogappapis.Rpositories.PostRepo;
import com.vijayblog.blogappapis.Rpositories.UserRepo;
import com.vijayblog.blogappapis.UserServices.PostService;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User id", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId));
        Post post = this.modelMapper.map(postDto,Post.class);
        post.setImageName("default.png");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setAddDate(new Date());
        post.setImageName(postDto.getImageName());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
        this.postRepo.delete(post);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostByID(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
        PostDto postDto = this.modelMapper.map(post,PostDto.class);

        return postDto;
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryID) {
        Category cat = this.categoryRepo.findById(categoryID).orElseThrow(()->new ResourceNotFoundException("Category","category ID", categoryID));

        List<Post> posts = this.postRepo.findByCategory(cat);
        List<PostDto>  postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer UserId) {
        User user = this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", UserId));

        List<Post> posts = this.postRepo.findByUser(user);

        List<PostDto> posDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return posDtos;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPost'");
    }

    
}
