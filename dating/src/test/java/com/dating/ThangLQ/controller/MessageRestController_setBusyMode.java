package com.dating.ThangLQ.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageRestController_setBusyMode {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void setBusymode_10 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/message/unknowlist/")
                                .param("busyMode", "false"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void setBusymode_11 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/message/unknowlist/")
                                .param("busyMode", "true"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
