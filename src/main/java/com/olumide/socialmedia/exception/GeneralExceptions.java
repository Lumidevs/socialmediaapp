package com.olumide.socialmedia.exception;

public class GeneralExceptions {

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public static class PostNotFoundException extends RuntimeException {
        public PostNotFoundException(String message) {
            super(message);
        }
    }

    public static class CommentNotFoundException extends RuntimeException {
        public CommentNotFoundException(String message) {
            super(message);
        }
    }

    public static class LikeNotFoundException extends RuntimeException {
        public LikeNotFoundException(String message) {
            super(message);
        }
    }
}

