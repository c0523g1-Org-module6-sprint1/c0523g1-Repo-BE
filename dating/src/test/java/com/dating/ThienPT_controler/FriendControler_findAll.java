package com.dating.ThienPT_controler;
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
public class FriendControler_findAll {
    @Autowired
    private MockMvc mockMvc;

    /**
     * author: ThienPT
     * date : 14/11/2023
     * Check case empty list friend
     *
     * @throws Exception
     * */

    @Test
    void findAll_5() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/relationship/friend")
                ).andDo(print())
                .andExpect(status().isNotFound());
    }


    /**
     * author: ThienPT
     * date : 14/11/2023
     * Check case success display list friend
     *
     * @throws Exception
     * */

    @Test
    void getAllStudent_6() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/public/relationship/friend"
                        )
                ).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].avatarAccount").value("zxc2"))
                .andExpect(jsonPath("$[0].nameLocation").value("Dânnag"))
                .andExpect(jsonPath("$[0].nameAccount").value("Nguyễn Ngọc Đông"))
                .andExpect(jsonPath("$[0].nameGender").value("female"))
                .andExpect(jsonPath("$[0].birthdayAccount").value("2023-11-14"))
                .andExpect(jsonPath("$[2].id").value(4))
                .andExpect(jsonPath("$[2].avatarAccount").value("zxc4"))
                .andExpect(jsonPath("$[2].nameLocation").value("Dânnag"))
                .andExpect(jsonPath("$[2].nameAccount").value("Hoàng Lê Quang"))
                .andExpect(jsonPath("$[2].nameGender").value("male"))
                .andExpect(jsonPath("$[2].birthdayAccount").value("2023-11-16"));
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case name variable has null value in url bar
     * with [name] is null
     *
     * @throws Exception
     * */

    @Test
    void findAll_name_7() throws Exception {
        String name = null;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/relationship/friend")
                                .param("name", name)
                ).andExpect(status().isBadRequest())
                .andDo(print());
    }


    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case name variable is empty value in url bar
     * with [name] is empty
     *
     * @throws Exception
     * */

    @Test
    void findAll_name_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/relationship/friend")
                                .param("name", "")
                ).andExpect(status().isBadRequest())
                .andDo(print());
    }


    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case name variable can not find value in database
     * with [name] can not find  in data
     *
     * @throws Exception
     * */

    @Test
    void findAll_name_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/relationship/friend")
                                .param("name", "Bray")
                ).andExpect(status().isBadRequest())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case name variable return list friend is empty in database
     * with [name] does exist in data
     *
     * @throws Exception
     * */

    @Test
    void findAll_name_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/relationship/friend")
                                .param("name", "a")
                ).andExpect(status().isNotFound())
                .andDo(print());
    }


    /**
     * author: ThienPT
     * date : 13/10/2023
     * goal: Check case name variable return size list friend > 0
     * with [name] does exist in data
     *
     * @throws Exception
     * */

    @Test
    void findAll_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/relationship/friend")
                                .param("name", "a")
                ).andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
}
