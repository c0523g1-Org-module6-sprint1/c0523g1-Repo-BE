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
public class PostController_getPostById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * DatNC
     * postId = null
     * @throws Exception
     */
    @Test
    public void getPostById_postId_1() throws Exception {
        String postId = null;
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/public/newsfeed/post/{postId}", postId)).andDo(print()).
                andExpect(status().is4xxClientError());
    }

    /**
     * DatNC
     * postId = ""
     * @throws Exception
     */

    @Test
    public void getPostById_postId_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/public/newsfeed/post/{postId}", "")).andDo(print()).
                andExpect(status().is4xxClientError());
    }

    /**
     * DatNC
     * postId = not exist
     * @throws Exception
     */

    @Test
    public void getPostById_postId_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/public/newsfeed/post/{postId}", 999999)).andDo(print()).
                andExpect(status().is4xxClientError());
    }

    /**
     * DatNC
     * postId = exist
     * @throws Exception
     */
    @Test
    public void getPostById_postId_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/public/newsfeed/post/{postId}", 5)).andDo(print()).
                andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(5))
                .andExpect(jsonPath("date").value("2023-11-10T00:00:00"))
                .andExpect(jsonPath("content").value("Hôm nay là thứ 7 !"))
                .andExpect(jsonPath("image").value("https://qph.cf2.quoracdn.net/main-qimg-a2c1929c7a4d83ef083413bdc1ed1662-pjlq"))
                .andExpect(jsonPath("account.id").value(6))
                .andExpect(jsonPath("privacyPost.id").value(1));
    }
}
