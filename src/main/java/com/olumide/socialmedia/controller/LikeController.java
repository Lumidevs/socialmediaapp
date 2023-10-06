package com.olumide.socialmedia.controller;

import com.olumide.socialmedia.models.Like;
import com.olumide.socialmedia.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        Like createdLike = likeService.createLike(like);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLike);
    }

    @GetMapping
    public ResponseEntity<List<Like>> getAllLikes() {
        List<Like> likes = likeService.getAllLikes();
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/{likeId}")
    public ResponseEntity<Like> getLikeById(@PathVariable Long likeId) {
        Optional<Like> like = likeService.getLikeById(likeId);

        if (like.isPresent()) {
            return ResponseEntity.ok(like.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long likeId) {
        likeService.deleteLike(likeId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{likeId}")
    public ResponseEntity<Like> updateLike(@PathVariable Long likeId, @RequestBody Like updatedLike) {
        Like updated = likeService.updateLike(likeId, updatedLike);
        return ResponseEntity.ok(updated);
    }
}

