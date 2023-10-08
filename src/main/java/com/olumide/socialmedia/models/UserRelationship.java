package com.olumide.socialmedia.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User follower;

    @ManyToOne
    private User following;

    public UserRelationship() {
    }

    public UserRelationship(User follower, User following) {
        this.follower = follower;
        this.following = following;
    }

}

