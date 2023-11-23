package com.dating.DatNC_controller;

import com.dating.dto.post.PostDto;
import com.dating.model.post.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostController_updateForAdmin {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * DatNC
     * post = null
     *
     * @throws Exception
     */
    @Test
    public void updateForAdmin_19() throws Exception {
        PostDto post = null;
        String postJson = null;
        postJson = this.objectMapper.writeValueAsString(post);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/newsfeed/post/admin/5")
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * DatNC
     * post valid
     *
     * @throws Exception
     */
    @Test
    public void updateForAdmin_24() throws Exception {
        PostDto postDto = new PostDto(5, "Hôm nay là thứ 2", "https://qph.cf2.quoracdn.net/main-qimg-778b835d6d8c7450adaf34daf6dbcdda-lq", false, 1);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/newsfeed/post/admin/{postId}", 5)
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
