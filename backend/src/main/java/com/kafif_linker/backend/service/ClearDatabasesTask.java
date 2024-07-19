package com.kafif_linker.backend.service;

import com.kafif_linker.backend.repository.UrlEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClearDatabasesTask {
    private final LinkShorterService linkShorter;

    @Scheduled(cron = "0 1 10 * * *", zone = "Europe/Moscow")
    public void execute() {
        linkShorter.deleteAllExpiredUrlsFromDatabase();
        log.info("Successfully cleared expired URLs from database.");
    }
}
