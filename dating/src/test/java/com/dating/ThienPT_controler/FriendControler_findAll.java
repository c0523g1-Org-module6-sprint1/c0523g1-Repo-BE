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
     * date : 16/11/2023
     * Check case empty list friend
     *
     * @throws Exception
     * */

    @Test
    void findAll_5() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin", String.valueOf(1000))
                                .param("name","abc")
                ).andDo(print())
                .andExpect(status().isNotFound());
    }


    /**
     * author: ThienPT
     * date : 16/11/2023
     * Check case success display list friend
     * return list friend in database
     * @throws Exception
     * */

    @Test
    void getAllStudent_6() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/api/public/friend"
                                ).param("name","")
                                .param("idLogin", String.valueOf(1))
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
     * date : 16/10/2023
     * goal: Check case  param variable name has null value
     * with [name] = null
     *
     * @throws Exception
     * */

    @Test
    void findAll_name_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin", String.valueOf(1))
                ).andExpect(status().isBadRequest())
                .andDo(print());
    }


    /**
     * author: ThienPT
     * date : 16/10/2023
     * goal: Check case  param variable name is empty value
     * with [name] is empty
     * return list friend in database
     * @throws Exception
     * */

    @Test
    void findAll_name_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin", String.valueOf(1))
                                .param("name", "")
                ).andExpect(status().is2xxSuccessful())
                .andDo(print());
    }


    /**
     * author: ThienPT
     * date : 16/10/2023
     * goal: Check case name variable can not find value in database
     * with [name] can not find  in data
     *
     * @throws Exception
     * */

    @Test
    void findAll_name_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin", String.valueOf(1))
                                .param("name", "Bray")
                ).andExpect(status().isNotFound())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 16/10/2023
     * goal: Check case name variable return list friend is empty in database
     * with [name] does exist in data
     *
     * @throws Exception
     * */

    @Test
    void findAll_name_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin", String.valueOf(100000))
                                .param("name", "a")
                ).andExpect(status().isNotFound())
                .andDo(print());
    }


    /**
     * author: ThienPT
     * date : 16/10/2023
     * goal: Check case name variable return size list friend > 0
     * with [name] does exist in data
     * return list friend in database
     * @throws Exception
     * */

    @Test
    void findAll_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin", String.valueOf(1))
                                .param("name", "a")
                ).andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 16/10/2023
     * goal: Check case idLogin is null
     * with [idLogin] = null
     *
     * @throws Exception
     * */

    @Test
    void findAll_idLogin_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("name", "a")
                ).andExpect(status().isBadRequest())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 16/10/2023
     * goal: Check case idLogin is empty
     * with [idLogin] = ""
     *
     * @throws Exception
     * */

    @Test
    void findAll_idLogin_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin","")
                                .param("name", "a")
                ).andExpect(status().isBadRequest())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 16/10/2023
     * goal: Check case idLogin is not exist in database
     * with [idLogin] = 100000
     *
     * @throws Exception
     * */

    @Test
    void findAll_idLogin_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin", String.valueOf(100000))
                                .param("name", "a")
                ).andExpect(status().isNotFound())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 16/10/2023
     * goal: Check case idLogin is exist in database but size list friend = 0
     * with [idLogin] = 1
     *
     * @throws Exception
     * */

    @Test
    void findAll_idLogin_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin", String.valueOf(1))
                                .param("name", "abcn")
                ).andExpect(status().isNotFound())
                .andDo(print());
    }

    /**
     * author: ThienPT
     * date : 16/10/2023
     * goal: Check case idLogin is exist in database but size list friend > 0
     * with [idLogin] = 1
     *
     * @throws Exception
     * */

    @Test
    void findAll_idLogin_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/friend")
                                .param("idLogin", String.valueOf(1))
                                .param("name", "")
                ).andExpect(status().is2xxSuccessful())
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
                .andExpect(jsonPath("$[2].birthdayAccount").value("2023-11-16"))
                .andDo(print());
    }
}