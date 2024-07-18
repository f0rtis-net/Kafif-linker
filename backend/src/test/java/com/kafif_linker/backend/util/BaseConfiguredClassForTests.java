package com.kafif_linker.backend.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@ActiveProfiles("testcontainers")
@Testcontainers
@AutoConfigureMockMvc
public abstract class BaseConfiguredClassForTests {
    @Autowired
    protected MockMvc mockMvc;
}
