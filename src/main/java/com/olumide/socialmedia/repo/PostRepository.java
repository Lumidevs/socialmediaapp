package com.olumide.socialmedia.repo;

import com.olumide.socialmedia.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAll();

    Optional<Post> findById(Long postId);

    void deleteById(Long postId);

    List<Post> findByUserId(Long userId);

}

