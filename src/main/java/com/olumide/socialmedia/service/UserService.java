package com.olumide.socialmedia.service;

import com.olumide.socialmedia.exception.GeneralExceptions;
import com.olumide.socialmedia.models.User;
import com.olumide.socialmedia.models.UserRelationship;
import com.olumide.socialmedia.repo.UserRepository;
import com.olumide.socialmedia.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;


    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword().trim()));
        return userRepository.save(user);
    }
    public User loginuser(User user, HttpServletResponse response) {

        log.info("user {}" , user);

            Optional<User> userDetails = userRepository.findByUsername(user.getUsername());

            if (userDetails.isPresent()){
               User validatedUser = userDetails.get();
               boolean passwordCorrect = passwordEncoder.matches(user.getPassword(), validatedUser.getPassword());
               if(passwordCorrect){
                   String token=jwtUtils.generateToken(user.getUsername());
                   log.info("token " + token);
                   response.setHeader("Authorization", token);
                   return userDetails.get();

               }else{
                   throw new GeneralExceptions.UserNotFoundException("Invalid login credentials for: " + user.getUsername() );

               }

            }
        throw new GeneralExceptions.UserNotFoundException("User not found with username: " + user.getUsername() );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(userId);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            // Update user properties here
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setProfilePicture(updatedUser.getProfilePicture());

            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            throw new GeneralExceptions.UserNotFoundException("User not found with ID: " + userId);
        }
    }


    @Transactional
    public void followUser(Long followerId, Long followingId) {
        User follower = userRepository.findById(followerId).orElseThrow(() -> new GeneralExceptions.UserNotFoundException("Follower not found"));
        User following = userRepository.findById(followingId).orElseThrow(() -> new GeneralExceptions.UserNotFoundException("Following user not found"));

        if (!isFollowing(follower, following)) {
            UserRelationship relationship = new UserRelationship(follower, following);
            follower.getFollowingRelationships().add(relationship);
            userRepository.save(follower);
        }
    }

    @Transactional
    public void unfollowUser(Long followerId, Long followingId) {
        User follower = userRepository.findById(followerId).orElseThrow(() -> new GeneralExceptions.UserNotFoundException("Follower not found"));
        User following = userRepository.findById(followingId).orElseThrow(() -> new GeneralExceptions.UserNotFoundException("Following user not found"));

        follower.getFollowingRelationships().removeIf(relationship -> relationship.getFollowing().equals(following));
        userRepository.save(follower);
    }

    private boolean isFollowing(User follower, User following) {
        return follower.getFollowingRelationships().stream()
                .anyMatch(relationship -> relationship.getFollowing().equals(following));
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

