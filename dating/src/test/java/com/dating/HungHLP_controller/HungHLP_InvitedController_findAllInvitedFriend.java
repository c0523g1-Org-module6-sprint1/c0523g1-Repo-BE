package com.dating.HungHLP_controller;

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
public class HungHLP_InvitedController_findAllInvitedFriend {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/invited"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Danh sach rong, tim kiem .....
     *
     * @throws Exception
     */
    @Test
    public void findAll_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/invited"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Ronaldo delima"))
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].avatar").value("http://beedoctor.vn/wp-content/uploads/2020/03/ronaldo-beo-2.jpg"))
                .andExpect(jsonPath("$[0].dateRequest").value("2023-10-11 00:00:00"));

    }
}
