package com.olumide.socialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GeneralExceptions.UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(GeneralExceptions.UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(GeneralExceptions.PostNotFoundException.class)
    public ResponseEntity<String> handlePostNotFoundException(GeneralExceptions.PostNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(GeneralExceptions.CommentNotFoundException.class)
    public ResponseEntity<String> handleCommentNotFoundException(GeneralExceptions.CommentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(GeneralExceptions.LikeNotFoundException.class)
    public ResponseEntity<String> handleLikeNotFoundException(GeneralExceptions.LikeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Add more exception handlers as needed for other custom exceptions

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
}

