package com.olumide.socialmedia.service;

import com.olumide.socialmedia.exception.GeneralExceptions;
import com.olumide.socialmedia.models.Like;
import com.olumide.socialmedia.repo.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    public Optional<Like> getLikeById(Long likeId) {
        return likeRepository.findById(likeId);
    }

    public void deleteLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }

    public Like updateLike(Long likeId, Like updatedLike) {
        Optional<Like> existingLikeOptional = likeRepository.findById(likeId);

        if (existingLikeOptional.isPresent()) {
            Like existingLike = existingLikeOptional.get();
            // Update like properties here
            // For example, you can update the user or post associated with the like
            existingLike.setUser(updatedLike.getUser());
            existingLike.setPost(updatedLike.getPost());
            return likeRepository.save(existingLike);
        } else {
            throw new GeneralExceptions.LikeNotFoundException("Like not found with ID: " + likeId);
        }
    }

    public List<Like> getLikesForPost(Long postId) {
        return likeRepository.findByPostId(postId);
    }
}

