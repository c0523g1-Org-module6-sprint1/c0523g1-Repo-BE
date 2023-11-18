package com.dating.HungHLP_controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HungHLP_InvitedController_findAllInvitedFriend {

    /**
     * Path Variable id
     * description success display  invited friend list
     * HungHLP 16-11-2023
     * return invited friend list
     * @throws Exception
     */

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/invited/1")
                                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].nameAccount").value("Karim Benzema"))
                .andExpect(jsonPath("$[0].id").value(45))
                .andExpect(jsonPath("$[0].avatarAccount").value("https://wallpapercave.com/wp/wp5844467.jpg"))
                .andExpect(jsonPath("$[0].dateRequest").value("2023-10-14 00:00:00.0"));
    }


    /**
     * author: HungHLP
     * date : 16/11/2023
     * goal: Check case name variable has null value in url bar
     * with [id] is null
     *
     * @throws Exception
     * */

    @Test
    void findAll_id_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/invited/")
                ).andExpect(status().isNoContent())
                .andDo(print());
    }

    /**
     * author: HungHLP
     * date : 16/11/2023
     * goal: Check case id variable can not find value in database
     * with [id] can not find  in data
     *
     * @throws Exception
     * */

    @Test
    void findAll_id_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/invited/87")
                ).andExpect(status().isNoContent())
                .andDo(print());
    }

    /**
     * author: HungHLP
     * date : 13/10/2023
     * goal: Check case id variable return list friend invited is empty in database
     * with [id] does exist in data
     *
     * @throws Exception
     * */

    @Test
    void findAll_id_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/invited/87")
                ).andExpect(status().isNoContent())
                .andDo(print());
    }
}
