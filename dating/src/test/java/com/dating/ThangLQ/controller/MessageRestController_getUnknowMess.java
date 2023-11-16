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
public class MessageRestController_getUnknowMess {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUnknowList_5 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/message/unknowlist/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
