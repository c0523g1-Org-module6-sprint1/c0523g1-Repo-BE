package com.dating.HanhNTM_controller;

import com.dating.dto.search_advanced.SearchAvancedDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountsController_getAll {

    @Autowired
    private MockMvc mockMvc;

    /**
     * method searchAdvanced
     * Create HanhNTM
     * Date 14-11-2023
     * param no
     * return new Object: Search Advanced
     */

    @Test
    public void getAll_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/search_advanced/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getAll_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/search_advanced/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Mỹ Hạnh"))
                .andExpect(jsonPath("$[0].avatar").value("https://usth.edu.vn/wp-content/uploads/2022/06/1557717551734-codegym.png"))
                .andExpect(jsonPath("$[0].location").value("Đã Nẵng"))
                .andExpect(jsonPath("$[0].job").value("it"));
    }

    

//    @Test
//    public void getAll_5() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/search_advanced")
//                        .param("genderId", "1")
//                        .param("locationId", "1")
//                        .param("jobId", "1")
//                        .param("hobbyDetailId", "1"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("name").value("Mỹ Hạnh"))
//                .andExpect(jsonPath("avatar").value("https://usth.edu.vn/wp-content/uploads/2022/06/1557717551734-codegym.png"))
//                .andExpect(jsonPath("location").value("Đà Nẵng"))
//                .andExpect(jsonPath("job").value("it"));

//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/public/search_advanced/Mỹ Hạnh/2000-10-10/1/1/1/1"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//                .andExpect(jsonPath("name").value("Mỹ Hạnh"))
//                .andExpect(jsonPath("avatar").value("https://usth.edu.vn/wp-content/uploads/2022/06/1557717551734-codegym.png"))
//                .andExpect(jsonPath("location").value("Đã Nẵng"))
//                .andExpect(jsonPath("job").value("it"));
//    }


}
