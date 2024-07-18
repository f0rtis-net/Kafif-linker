package com.kafif_linker.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ShortUrlGenerator {
    private static final String ALLOWED_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final char[] ALLOWED_CHARACTERS = ALLOWED_ALPHABET.toCharArray();
    private static final int base = ALLOWED_CHARACTERS.length;

    public String generateShortUrlById(Long entityId) {
        if(entityId < 1000)
            entityId += 1000; // normalize id

        var encodedString = new StringBuilder();

        if(entityId == 0) {
            return String.valueOf(ALLOWED_CHARACTERS[0]);
        }

        while (entityId > 0) {
            encodedString.append(ALLOWED_CHARACTERS[(int) (entityId % base)]);
            entityId = entityId / base;
        }

        return encodedString.reverse().toString();
    }

    public Long decodeEntityIdByShortUrl(String shortUrl) {
        var characters = shortUrl.toCharArray();
        var length = characters.length;

        var decoded = 0L;

        //counter is used to avoid reversing input string
        var counter = 1;
        for (char character : characters) {
            decoded += (long) (ALLOWED_ALPHABET.indexOf(character) * Math.pow(base, length - counter));
            counter++;
        }
        return decoded;
    }
}
