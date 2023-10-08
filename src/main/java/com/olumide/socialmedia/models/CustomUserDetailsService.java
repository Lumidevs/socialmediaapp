package com.olumide.socialmedia.models;

import com.olumide.socialmedia.exception.GeneralExceptions;
import com.olumide.socialmedia.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService{

    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String username)  {

        Optional<User> userEntity = userRepository.findUserByUsernameEqualsIgnoreCase(username);
        if(userEntity.isPresent()){
            return userEntity.get();
        }
        throw new GeneralExceptions.UserNotFoundException("User not found with username: " + username);

    }




}
