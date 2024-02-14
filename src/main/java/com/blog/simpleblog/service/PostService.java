package com.blog.simpleblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.simpleblog.repository.PostRepository;
import com.blog.simpleblog.vo.Post;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public Post getPost(Long id) {
        Post post = postRepository.findOne(id);
        return post;
    }

    public List<Post> getPosts() {
        List<Post> postList = postRepository.findPost();
        return postList;
    }

    public List<Post> getPostsOrderByUpdtAsc() {
        List<Post> postList = postRepository.findPostOrderByUpdtDateAsc();
        return postList;
    }

    public List<Post> getPostsOrderByRegDesc() {
        List<Post> postList = postRepository.findPostOrderByRegDateDesc();
        return postList;
    }

    public List<Post> getPostsByTitle(String query) {
        List<Post> postList = postRepository.findPostLikeTitle(query);
        return postList;
    }

    public List<Post> searchPostByContent(String query) {
        List<Post> postList = postRepository.findPostLikeContent(query);
        return postList;
    }

    public boolean savePost(Post post) {
        int result = postRepository.savePost(post);
        boolean isSuccess = true;
        if (result == 0) {
            isSuccess = false;
        }
        return isSuccess;
    }
}
