package com.dating.HanhNTM_controller;

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
public class AccountTopController_getAll {
    @Autowired
    private MockMvc mockMvc;


    /**
     * method displayTopHundered
     * Create HanhNTM
     * Date 14-11-2023
     * param no
     * return new Object: Top Hundered
     */

    @Test
    public void getAll_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/top_hundered"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getAll_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/top_hundered"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Mỹ Hạnh"))
                .andExpect(jsonPath("$[0].avatar").value("https://usth.edu.vn/wp-content/uploads/2022/06/1557717551734-codegym.png"))
//                .andExpect(jsonPath("$[0].account_type").value(1))
//                .andExpect(jsonPath("$[0].likeDetail").value(1))
                .andExpect(jsonPath("$[0].money").value(200));
    }
}
