package com.kafif_linker.backend.integration;

import com.kafif_linker.backend.util.BaseConfiguredClassForTests;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RequiredArgsConstructor
class LinkShorterServiceTest extends BaseConfiguredClassForTests {
	@Test
	void shouldFailOnValidation_invalidUrlFormat_postAction() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/shorter/short")
						.content("      "))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/shorter/short")
						.content(""))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void shouldFailOnValidation_invalidUrlContent_postAction() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/shorter/short")
						.content("http://localhost:8080"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void shouldSuccess_ProperData_postAction() throws Exception {
		var result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/shorter/short")
						.content("https://ya.ru"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		var encodedUrl = result.getResponse().getContentAsString();

		Assertions.assertFalse(encodedUrl.isEmpty());
	}
}
