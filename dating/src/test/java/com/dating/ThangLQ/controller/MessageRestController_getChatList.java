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
public class MessageRestController_getChatList {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getChatList_5 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/chats/",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getChatList_6 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/chats/",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
