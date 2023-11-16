package com.dating.DatNC_controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostController_showListOfAnAccount {
    @Autowired
    private MockMvc mockMvc;

    /**
     * DatNC
     * accountId = null
     * @throws Exception
     */
    @Test
    public void showListOfAnAccount_accountId_1() throws Exception {
        String accountId = null;
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/public/newsfeed/post/account}",accountId)).andDo(print()).
                andExpect(status().is4xxClientError());
    }

    /**
     * DatNC
     * accountId = ""
     * @throws Exception
     */

    @Test
    public void showListOfAnAccount_accountId_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/public/newsfeed/post/account/{accountId}", "")).andDo(print()).
                andExpect(status().is4xxClientError());
    }

    /**
     * DatNC
     * accountId = not exist
     * @throws Exception
     */

    @Test
    public void showListOfAnAccount_accountId_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/public/newsfeed/post/account/{accountId}", 999999)).andDo(print()).
                andExpect(status().is4xxClientError());
    }
    /**
     * DatNC
     * accountId = exist
     * @throws Exception
     */
    @Test
    public void showListOfAnAccount_accountId_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/public/newsfeed/post/account/{accountId}", 6)).andDo(print()).
                andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id").value(5))
                .andExpect(jsonPath("$[0].date").value("2023-11-10T00:00:00"))
                .andExpect(jsonPath("$[0].content").value("Hôm nay là thứ 7 !"))
                .andExpect(jsonPath("$[0].image").value("https://qph.cf2.quoracdn.net/main-qimg-a2c1929c7a4d83ef083413bdc1ed1662-pjlq"))
                .andExpect(jsonPath("$[0].account.id").value(6))
                .andExpect(jsonPath("$[0].privacyPost.id").value(1));
    }
}
