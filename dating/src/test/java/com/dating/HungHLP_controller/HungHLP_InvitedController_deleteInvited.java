package com.dating.HungHLP_controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HungHLP_InvitedController_deleteInvited {


    @Autowired
    private MockMvc mockMvc;

    /**
     * ID = null
     * HungHLP 15-11-2023
     * deleted fail
     *
     * @throws Exception
     */


    @Test
    public void deleteInvited_id() throws Exception {
        Long id = null;
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/public/invited/delete/{id}", id))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * HungHLP 15-11-2023
     * id = ""
     * deleted fail
     *
     * @throws Exception
     */
    @Test
    public void deleteInvited_id_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/public/invited/delete/{id}", ""))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}

