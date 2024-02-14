package com.blog.simpleblog.service;

import org.springframework.stereotype.Service;

import com.blog.simpleblog.vo.Post;

@Service
public class PostService {
    public Post getPost() {
        Post post = new Post(1L, "Dafa", "First Blog", "Welcome to my blog!");
        return post;
    }
}
