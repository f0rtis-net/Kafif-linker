package com.kafif_linker.backend.model.dto.request;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.kafif_linker.backend.model.entity.UrlEntity}
 */
@Value
public class CreateUrlNoteRequest implements Serializable {
    String longUrl;
    Date expiresIn;
    Date createdAt;
}