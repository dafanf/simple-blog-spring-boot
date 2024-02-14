package com.blog.simpleblog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.simpleblog.vo.Post;

@Service
public class PostService {
    // private static List<Post> posts;
    public Post getPost(int id) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Dafa", "First Blog", "Welcome to my blog!"));
        posts.add(new Post(2L, "Dafa", "Second Blog", "This is my second blog!"));
        posts.add(new Post(3L, "Dafa", "Third Blog", "This is my third blog!"));
        Post post = posts.get(id - 1);
        return post;
    }

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Dafa", "First Blog", "Welcome to my blog!"));
        posts.add(new Post(2L, "Dafa", "Second Blog", "This is my second blog!"));
        posts.add(new Post(3L, "Dafa", "Third Blog", "This is my third blog!"));
        return posts;
    }
}
