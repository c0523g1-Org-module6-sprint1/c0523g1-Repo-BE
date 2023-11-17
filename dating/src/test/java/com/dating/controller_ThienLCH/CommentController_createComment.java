package com.dating.controller_ThienLCH;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class CommentController_getComment {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: get comment with id equal ""
     *
     * @return HttpStatus 2xx
     */
    @Test
    public void getInfoComment_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/comment/{id}", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: get comment with id exists
     *
     * @return HttpStatus 2xx
     */
    @Test
    public void getInfoComment_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/comment/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: get comment with id does not exists
     *
     * @return HttpStatus 4xx
     */

    @Test
    public void getInfoComment_id_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/comment/{id}", "5"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
