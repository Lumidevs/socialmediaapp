package com.olumide.socialmedia.repo;

import com.olumide.socialmedia.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findAll();

    Optional<Like> findById(Long likeId);

    void deleteById(Long likeId);

    List<Like> findByPostId(Long postId);

}

