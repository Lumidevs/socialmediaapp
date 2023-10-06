package com.olumide.socialmedia.repo;

import com.olumide.socialmedia.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Create a new user
    User save(User user);

    // Retrieve all users
    List<User> findAll();

    // Retrieve a user by ID
    Optional<User> findById(Long userId);

    // Delete a user by ID
    void deleteById(Long userId);

}
