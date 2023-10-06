package com.olumide.socialmedia.service;

import com.olumide.socialmedia.exception.GeneralExceptions;
import com.olumide.socialmedia.models.Post;
import com.olumide.socialmedia.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long postId) {
        return postRepository.findById(postId);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public Post updatePost(Long postId, Post updatedPost) {
        Optional<Post> existingPostOptional = postRepository.findById(postId);

        if (existingPostOptional.isPresent()) {
            Post existingPost = existingPostOptional.get();
            // Update post properties here
            existingPost.setContent(updatedPost.getContent());
            // Update other properties as needed
            return postRepository.save(existingPost);
        } else {
            throw new GeneralExceptions.PostNotFoundException("Post not found with ID: " + postId);
        }
    }


    public List<Post> getPostsForUser(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
