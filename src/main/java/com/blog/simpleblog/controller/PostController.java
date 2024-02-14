package com.blog.simpleblog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.blog.simpleblog.service.PostService;
import com.blog.simpleblog.vo.Post;

import java.util.ArrayList;
import java.util.List;

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
    public List<Post> getPosts() {
        List<Post> posts = postService.getPosts();
        return posts;
    }
    
}
