package com.kafif_linker.backend.service;

import com.kafif_linker.backend.repository.UrlEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClearDatabasesTask {
    private final LinkShorterService linkShorter;

    @Scheduled(cron = "10 * * * * *")
    public void execute() {
        linkShorter.deleteAllExpiredUrls();
    }
}
