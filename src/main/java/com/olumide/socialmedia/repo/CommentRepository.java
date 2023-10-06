package com.olumide.socialmedia.repo;

import com.olumide.socialmedia.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAll();

    Optional<Comment> findById(Long commentId);

    void deleteById(Long commentId);
}

