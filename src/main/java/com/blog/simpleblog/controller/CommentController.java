package com.blog.simpleblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blog.simpleblog.service.CommentService;
import com.blog.simpleblog.vo.Comment;
import com.blog.simpleblog.vo.Result;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;
    @GetMapping("/comments")
    public List<Comment> getComments(@RequestParam("post_id") Long postId) {
        return commentService.getComments(postId);
    }
    
    @GetMapping("/comment")
    public Object getComment(@RequestParam("id") Long id) {
        return commentService.getComment(id);
    }
    
    @PostMapping("/comment")
    public Object savePost(HttpServletResponse response, @RequestBody Comment commentParam) {
        Comment comment = new Comment(commentParam.getPostId(), commentParam.getUser(), commentParam.getComment());
        boolean isSuccess = commentService.saveComment(comment);
        if (isSuccess) {
            return new Result(200, "success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "fail");
        }
    }

    @DeleteMapping("/comment")
    public Object deleteComment(HttpServletResponse response, @RequestParam("id") Long id) {
        boolean isSuccess = commentService.deleteComment(id);
        if (isSuccess) {
            return new Result(200, "success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "fail");
        }
    }

    @GetMapping("/comments/search")
    public List<Comment> searchCommentByComment(@RequestParam("post_id") Long post_id, @RequestParam("query") String query) {
        return commentService.searchCommentByComment(post_id, query);
    }
    
}
