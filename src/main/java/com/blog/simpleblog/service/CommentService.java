package com.blog.simpleblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.simpleblog.repository.CommentJpaRepository;
import com.blog.simpleblog.vo.Comment;

@Service
public class CommentService {

    @Autowired
    CommentJpaRepository commentJpaRepository;
    public boolean saveComment(Comment comment) {
        Comment result = commentJpaRepository.save(comment);
        boolean isSuccess = true;
        if (result == null) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public List<Comment> getComments(Long postId){
        List<Comment> commentList = commentJpaRepository.findByPostIdOrderByRegDateDesc(postId);
        return commentList;
    }

    public Comment getComment(Long id){
        Comment comment = commentJpaRepository.findOneById(id);
        return comment;
    }

    public boolean deleteComment(Long id){
        Comment comment = commentJpaRepository.findOneById(id);
        if (comment == null) {
            return false;
        }
        commentJpaRepository.deleteById(id);
        return true;
    }

    public List<Comment> searchCommentByComment(Long post_id, String query) {
        List<Comment> commentList = commentJpaRepository.findByPostIdAndCommentContainingOrderByRegDateDesc(post_id, query);
        return commentList;
    }
}
