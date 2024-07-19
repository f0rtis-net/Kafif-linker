package com.kafif_linker.backend.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class RedisCacheConfig {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        return RedisCacheManager.RedisCacheManagerBuilder.
                fromConnectionFactory(factory)
                .withCacheConfiguration("urlCache",
                        RedisCacheConfiguration
                                .defaultCacheConfig()
                                .disableCachingNullValues()
                )
                .build();
    }
}
