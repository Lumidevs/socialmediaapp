package com.olumide.socialmedia.models;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;
        private String email;
        private String profilePicture;

        @OneToMany(mappedBy = "user")
        private List<Post> posts = new ArrayList<>();

        @ManyToMany
        @JoinTable(
                name = "user_follows",
                joinColumns = @JoinColumn(name = "follower_id"),
                inverseJoinColumns = @JoinColumn(name = "following_id")
        )
        private Set<User> following = new HashSet<>();

        @ManyToMany(mappedBy = "following")
        private Set<User> followers = new HashSet<>();

}
