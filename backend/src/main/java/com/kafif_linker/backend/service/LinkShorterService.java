package com.kafif_linker.backend.service;

import com.kafif_linker.backend.exception.UrlInvalidFormatException;
import com.kafif_linker.backend.exception.UrlIsNotExistsException;
import com.kafif_linker.backend.model.dto.request.DeleteUrlEntityDto;
import com.kafif_linker.backend.model.entity.UrlEntity;
import com.kafif_linker.backend.repository.UrlEntityRepository;
import com.kafif_linker.backend.repository.specification.UrlEntitySpecificationBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
@Slf4j
public class LinkShorterService {
    private final UrlEntityRepository urlEntityRepository;
    private final ShortUrlGenerator shortUrlGenerator;

    @Transactional
    public String getShortUrlByLong(String url) {
        if (!this.validateUrl(url)) {
            throw new UrlInvalidFormatException();
        }

        log.info("Generating shortUrl for url: {}", url);
        var urlEntity = new UrlEntity();
        urlEntity.setId(null);
        urlEntity.setLongUrl(url);

        var date = new Date();
        urlEntity.setCreatedAt(date);
        urlEntity.setExpiresIn(DateUtils.addDays(date, 30));

        UrlEntity response = urlEntityRepository.save(urlEntity);

        return shortUrlGenerator.generateShortUrlById(response.getId());
    }

    @Cacheable(value = "urlCache", key = "#shortUrl")
    public String getLongUrlByShort(String shortUrl) {
        if (!this.validateUrl(shortUrl)) {
            throw new UrlInvalidFormatException();
        }

        log.info("Getting non cached url from database. ShortUrl: {}", shortUrl);

        Long id = shortUrlGenerator.decodeEntityIdByShortUrl(shortUrl);

        return urlEntityRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Could not find url with shortUrl: {}", shortUrl);
                    return new UrlIsNotExistsException(shortUrl);
                })
                .getLongUrl();
    }

    @Transactional
    public void deleteAllExpiredUrlsFromDatabase() {
        Date currentDate = new Date();
        urlEntityRepository.delete(UrlEntitySpecificationBuilder.build(new DeleteUrlEntityDto(null, currentDate)));
    }

    private boolean validateUrl(String url) {
        return StringUtils.isNotBlank(url);
    }
}
