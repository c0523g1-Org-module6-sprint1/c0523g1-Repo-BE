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
        this.mockMvc.perform(MockMvcRequestBuilders.get("/accounts/","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListAccount_() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/accounts/",""))
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
        this.mockMvc.perform(MockMvcRequestBuilders.get("/accounts/", "ronaldo123"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].userName").value("ronaldo123"))
                .andExpect(jsonPath("content[0].regisDate").value("2023-10-10"))
                .andExpect(jsonPath("content[0].money").value("1000000.0"))
                .andExpect(jsonPath("content[0].faultAmount").value("1"))
                .andExpect(jsonPath("content[0].description").value("1"))
                .andExpect(jsonPath("content[0].dateWarning").value("2023-11-11 00:00:00.0"))
                ;

    }

}
