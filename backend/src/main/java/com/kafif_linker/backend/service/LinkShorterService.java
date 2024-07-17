package com.kafif_linker.backend.service;

import com.kafif_linker.backend.model.dto.request.DeleteUrlEntityDto;
import com.kafif_linker.backend.repository.UrlEntityRepository;
import com.kafif_linker.backend.repository.specification.UrlEntitySpecificationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class LinkShorterService {
    private final UrlEntityRepository urlEntityRepository;

    public String shortUrl(String url) {
        return null;
    }

    public String getLongUrlByShort(String shortUrl) {
        return null;
    }

    public void deleteAllExpiredUrls() {
        Date current = new Date();
        urlEntityRepository.delete(UrlEntitySpecificationBuilder.build(new DeleteUrlEntityDto(null, current)));
    }
}
