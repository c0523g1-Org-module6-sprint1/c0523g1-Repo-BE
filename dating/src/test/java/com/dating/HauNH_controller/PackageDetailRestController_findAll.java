package com.dating.HauNH_controller;

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
public class PackageDetailRestController_findAll {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Method: findAll_5,
     * Create: HauNH,
     * Date  : 14/11/2023
     * param : no
     * return: status
     */
    @Test
    public void findAll_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/packageDetail"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Method: findAll_6,
     * Create: HauNH,
     * Date  : 14/11/2023
     * param : no
     * return: Return 1 list object PackageDetail & status
     *
     *
     */
    @Test
    public void findAll_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/packageTypes"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
