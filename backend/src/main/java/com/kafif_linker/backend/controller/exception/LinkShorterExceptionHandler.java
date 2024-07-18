package com.kafif_linker.backend.controller.exception;

import com.kafif_linker.backend.exception.UrlInvalidFormatException;
import com.kafif_linker.backend.exception.UrlIsNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkShorterExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleException(UrlIsNotExistsException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(UrlInvalidFormatException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
