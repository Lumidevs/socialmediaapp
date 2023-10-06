package com.olumide.socialmedia.service;

import com.olumide.socialmedia.exception.GeneralExceptions;
import com.olumide.socialmedia.models.User;
import com.olumide.socialmedia.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // Add any validation or business logic here before saving the user
        return userRepository.save(user);
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
}

