package com.dating.LienDTM_controller;

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
public class SearchNameRestController_searchByName {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Search name = null
     * @throws Exception
     */
    @Test
    public void searchByName_7() throws Exception {
        String name = null;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/search-name/{name}", name))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    /**
     * Search name = ""
     * @throws Exception
     */
    @Test
    public void searchByName_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/search-name/{name}", ""))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    /**
     * Search name with list's size = 0
     * @throws Exception
     */
    @Test
    public void searchByName_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/search-name/{name}", "w"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Search name with list have record
     * @throws Exception
     */
    @Test
    public void searchByName_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/search-name/{name}", "a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Hanh"))
                .andExpect(jsonPath("$[0].avatar").value("a"))
                .andExpect(jsonPath("$[0].location").value("Đà Nẵng"))
                .andExpect(jsonPath("$[0].job").value("IT"))
                .andExpect(jsonPath("$[3].name").value("Phan Quốc Sang"))
                .andExpect(jsonPath("$[3].avatar").value("d"))
                .andExpect(jsonPath("$[3].location").value("Đà Nẵng"))
                .andExpect(jsonPath("$[3].job").value("IT"));
    }
}
