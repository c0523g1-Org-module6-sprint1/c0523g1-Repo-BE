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
public class MessageRestController_getChatbox {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getChatBox_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/message/Chatbox/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getChatBox_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/message/Chatbox/{id}", "999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getChatBox_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/message/Chatbox/{id}", "69"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getChatBox_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/message/Chatbox/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
