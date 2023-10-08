//package com.olumide.socialmedia.models;
//
//import com.olumide.socialmedia.repo.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository; // You'll need to create a UserRepository
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        // Implement logic to load user details from your database
//        // You can use the UserRepository to retrieve user information
//        // Return a UserDetails object representing the user
//        // Throw UsernameNotFoundException if the user is not found
//
//
//        User userEntity = userRepository.findUserByUsernameEqualsIgnoreCase(username);
//
//        if (userEntity == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//
//        // Create a UserDetails object representing the user
//        // You can customize the authorities and other attributes based on your application's needs
//        Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
//        UserDetails userDetails = new org.springframework.security.core.userdetails.User("username", "password", authorities);
//
//
//        return userDetails;
//
//    }
//}
