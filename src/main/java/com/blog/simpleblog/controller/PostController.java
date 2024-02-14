package com.blog.simpleblog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.blog.simpleblog.service.PostService;
import com.blog.simpleblog.vo.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public Post getPost() {
        Post post = postService.getPost();
        return post;
    }
    
    @GetMapping("/posts")
    public Post[] getPosts() {
        Post[] posts = new Post[]{
            new Post(1L, "Dafa", "First Blog", "Welcome to my blog!"),
            new Post(2L, "Dafa", "Second Blog", "Welcome to my blog!"),
            new Post(3L, "Dafa", "Third Blog", "Welcome to my blog!")
        };

        return posts;
    }
    
}
