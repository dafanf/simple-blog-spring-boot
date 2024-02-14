package com.blog.simpleblog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.blog.simpleblog.service.PostService;
import com.blog.simpleblog.vo.Post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public Post getPost(@RequestParam("id") int id) {
        Post post = postService.getPost(id);
        return post;
    }

    @GetMapping("/post/{id}")
    public Post getPostPathParam(@PathVariable("id") int id) {
        Post post = postService.getPost(id);
        return post;
    }
    
    @GetMapping("/posts")
    public List<Post> getPosts() {
        List<Post> posts = postService.getPosts();
        return posts;
    }
    
}
