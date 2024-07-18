package com.kafif_linker.backend.model.dto.response;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.kafif_linker.backend.model.entity.UrlEntity}
 */
@Value
public class GetUrlEntityDto implements Serializable {
    Long id;
    String longUrl;
    Date createdAt;
    Date expiresIn;
}