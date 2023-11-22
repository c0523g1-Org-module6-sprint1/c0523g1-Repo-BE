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
public class HungHLP_InvitedController_acceptInvited {

    /**
     * Path Variable invited id
     * id empty in database
     * description success accept invited
     * HungHLP 16-11-2023
     * return invited friend list
     * @throws Exception
     */

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accept_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/api/public/invited/accept/87")
                                )
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    /**
     * Path Variable invited id
     * id =null
     * description accept fail
     * HungHLP 16-11-2023
     * return invited friend list
     * @throws Exception
     */

    @Test
    public void accept_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/api/public/invited/accept/")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

}
