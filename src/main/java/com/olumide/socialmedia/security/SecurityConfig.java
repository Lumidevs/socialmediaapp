//package com.olumide.socialmedia.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    private final UserDetailsService userDetailsService;
//
//    private final JwtRequestFilter jwtRequestFilter;
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll() // Endpoint for authentication
//                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//}
//
