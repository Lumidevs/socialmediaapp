package com.olumide.socialmedia.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
    public class Like {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post post;

        // Getters and setters


}
