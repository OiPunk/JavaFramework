package com.mashibing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class I18nApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldRenderEnglishByDefault() throws Exception {
        mockMvc.perform(get("/login.html"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Sign in")));
    }

    @Test
    void shouldSwitchToSpanishWhenLangParameterProvided() throws Exception {
        mockMvc.perform(get("/login.html").param("lang", "es_ES"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Entrar")));
    }
}
