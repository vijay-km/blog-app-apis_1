package com.vijayblog.blogappapis.Payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    
    private Integer postId;
    // @Column(name = "post_title", length = 100,nullable = false)
    private String title;

    // @Column(length=10000)
    private String content;

    private String imageName;

    private Date addedDate;
    
    private CategoryDto category;

    private UserDto user;
    
}
