package com.olumide.socialmedia.service;

import com.olumide.socialmedia.exception.GeneralExceptions;
import com.olumide.socialmedia.models.Comment;
import com.olumide.socialmedia.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        comment.setCreationDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment updateComment(Long commentId, Comment updatedComment) {
        Optional<Comment> existingCommentOptional = commentRepository.findById(commentId);

        if (existingCommentOptional.isPresent()) {
            Comment existingComment = existingCommentOptional.get();
            existingComment.setCreationDate(LocalDateTime.now());

            existingComment.setComment(updatedComment.getComment());

            return commentRepository.save(existingComment);
        } else {
            throw new GeneralExceptions.CommentNotFoundException("Comment not found with ID: " + commentId);
        }
    }


    public List<Comment> getCommentsForPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}

