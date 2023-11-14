package com.dating.ThienBB_controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityController_logout {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Creator: ThienBB
     * Date created: 14/11/2023
     * Expect: Username is invalid
     *
     * @Throw: Exception
     */
    @Test
    public void logout_invalidUser_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/logout/{username}", ""))
                .andDo(print())
                .andExpect(status().is(400));
    }

    /**
     * Creator: ThienBB
     * Date created: 14/11/2023
     * Expect: Username is valid
     *
     * @Throw: Exception
     */
    @Test
    public void logout_validUser_100() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/logout/{username}", "user"))
                .andDo(print())
                .andExpect(status().is(200));
    }
}
