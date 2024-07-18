package com.kafif_linker.backend.integration;

import com.kafif_linker.backend.util.BaseConfiguredClassForTests;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RequiredArgsConstructor
class LinkShorterServiceTest extends BaseConfiguredClassForTests {
	@Test

	void shouldFailOnValidation_invalidUrlFormat_postAction() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/shorter/short")
						.param("url", "      "))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/shorter/short")
						.param("url", ""))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void shouldFailOnValidation_invalidUrlContent_postAction() throws Exception {

	}
}
