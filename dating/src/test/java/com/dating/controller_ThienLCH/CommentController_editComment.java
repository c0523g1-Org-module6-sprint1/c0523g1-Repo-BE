package com.dating.controller_ThienLCH;

import com.dating.dto.comment.CommentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CommentController_showList {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: get comment with id does not exists
     *
     * @return HttpStatus 4xx
     */
    @Test
    public void getListComment_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/comment"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: get list comment
     *
     * @return HttpStatus 2xx
     */
    @Test
    public void getListStudent_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/comment"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].content").value("Helo from the other world"))
                .andExpect(jsonPath("$[0].date").value("2023-11-15"))
                .andExpect(jsonPath("$[0].idDeleted").value(false))
                .andExpect(jsonPath("$[0].account.id").value(1))
                .andExpect(jsonPath("$[0].post.id").value(1))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].content").value("Helo from the other world"))
                .andExpect(jsonPath("$[1].date").value("2023-11-15"))
                .andExpect(jsonPath("$[1].idDeleted").value(false))
                .andExpect(jsonPath("$[1].account.id").value(2))
                .andExpect(jsonPath("$[1].post.id").value(1));
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: edit comment with comment real id
     *
     * @return HttpStatus 4xx
     */
    @Test
    public void editComment_name_25() throws Exception {
        CommentDto commentDto = new CommentDto();
        Integer id = 4;
        commentDto.setId(2);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/comment/" + id)
                                .content(this.objectMapper.writeValueAsString(commentDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: edit comment with id null
     *
     * @return HttpStatus 4xx
     */

    @Test
    public void editComment_name_26() throws Exception {
        CommentDto commentDto = new CommentDto();
        Integer id = null;
        commentDto.setId(2);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/comment/" + id)
                                .content(this.objectMapper.writeValueAsString(commentDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: edit comment with id is out of bound
     *
     * @return HttpStatus 4xx
     */
//
    @Test
    public void editComment_name_27() throws Exception {
        CommentDto commentDto = new CommentDto(7,"Helo from the other world",null,
                        false,1,1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/comment/" + commentDto.getId())
                                .content(this.objectMapper.writeValueAsString(commentDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
