package com.kafif_linker.backend.exception;

public class UrlInvalidFormatException extends RuntimeException {
    public UrlInvalidFormatException() {
        super("Url has invalid format");
    }
}
