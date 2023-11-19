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

    /**
     * Param accountID
     * description success display  invited friend list
     * HungHLP 16-11-2023
     * return invited friend list
     *
     * @throws Exception
     */

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/invited")
                                .param("accountID", String.valueOf(1))
                                .param("accountCheckId", String.valueOf(2)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].nameAccount").value("Ronaldo delima"))
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].avatarAccount").value("http://beedoctor.vn/wp-content/uploads/2020/03/ronaldo-beo-2.jpg"))
                .andExpect(jsonPath("$[0].dateRequest").value("2023-10-11 00:00:00.0"));
    }


    /**
     * Invited Friend List
     * Param accountID
     * HungHLP 15-11-2023
     *
     * @throws Exception
     */
    @Test
    public void findAll_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/invited"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }
}
