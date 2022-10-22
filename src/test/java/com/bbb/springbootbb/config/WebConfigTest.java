package com.bbb.springbootbb.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ActiveProfiles("local")
class WebConfigTest {

    @Autowired
    MockMvc mvc;

    @Test
    void test_add_resource_handler_success() throws Exception {
        this.mvc.perform(get("/m/test.html"))
                .andExpect(status().isOk());
    }

    @Test
    void test_add_resource_handler_fail() throws Exception {
        this.mvc.perform(get("/static/test.html"))
                .andExpect(status().isNotFound());
    }
}