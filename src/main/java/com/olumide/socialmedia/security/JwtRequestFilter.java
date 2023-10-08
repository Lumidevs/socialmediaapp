//package com.olumide.socialmedia.security;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtRequestFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final UserDetailsService userDetailsService;
//
//    public JwtRequestFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//        setAuthenticationManager(authenticationManager);
//    }
//
//    // Implement the filter logic to extract and validate JWT tokens
//    // and set up the authentication context
//}
