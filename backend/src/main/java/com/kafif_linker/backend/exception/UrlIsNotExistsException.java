package com.kafif_linker.backend.exception;

public class UrlIsNotExistsException extends RuntimeException {
    public UrlIsNotExistsException(String url) {
        super("Url " + url + " is not exists");
    }
}
