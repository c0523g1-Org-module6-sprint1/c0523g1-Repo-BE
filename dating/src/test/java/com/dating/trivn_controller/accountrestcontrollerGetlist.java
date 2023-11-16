package com.dating.trivn_controller;

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
public class accountrestcontrollerGetlist {
    @Autowired
    private MockMvc mockMvc;

    /**
     * TriVN
     * no data
     * @throws Exception
     */
    @Test
    public void getListAccount_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/accounts/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * TriVN
     * display data
     * @throws Exception
     */
    @Test
    public void getListAccount_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/accounts/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(25))
                .andExpect(jsonPath("content[0].user_name").value(""))
                .andExpect(jsonPath("content[0].regis_date").value(""))
                .andExpect(jsonPath("content[0].money").value(""))
                .andExpect(jsonPath("content[0].faut_amount").value(""))
                .andExpect(jsonPath("content[0].description").value(""))
                .andExpect(jsonPath("content[0].date").value(""))
                .andExpect(jsonPath("content[0].name").value(""))
                .andExpect(jsonPath("content[5].user_name").value(""))
                .andExpect(jsonPath("content[5].regis_date").value(""))
                .andExpect(jsonPath("content[5].money").value(""))
                .andExpect(jsonPath("content[5].faut_amount").value(""))
                .andExpect(jsonPath("content[5].description").value(""))
                .andExpect(jsonPath("content[5].date").value(""))
                .andExpect(jsonPath("content[5].name").value(""));
    }

}
