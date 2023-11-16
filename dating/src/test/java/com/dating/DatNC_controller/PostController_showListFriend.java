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
public class PostController_showListFriend {
    @Autowired
    private MockMvc mockMvc;

    /**
     * DatNC
     * no data
     * @throws Exception
     */
    @Test
    public void showListFriend_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/public/newsfeed/post/friend"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * DatNC
     * display data
     * @throws Exception
     */
    @Test
    public void showListFriend_6()  throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/newsfeed/post/friend"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].date").value("2023-11-10T00:00:00"))
                .andExpect(jsonPath("$[0].content").value("Thứ 7 máu chảy về... ?"))
                .andExpect(jsonPath("$[0].image").value("https://qph.cf2.quoracdn.net/main-qimg-778b835d6d8c7450adaf34daf6dbcdda-lq"))
                .andExpect(jsonPath("$[0].account.id").value("6"))
                .andExpect(jsonPath("$[0].privacyPost.id").value("2"));
    }

}
