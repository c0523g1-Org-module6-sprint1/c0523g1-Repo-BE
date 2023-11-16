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
public class HungHLP_RecommendController_findAllRecommendFriend {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Danh sach rong
     * Param accountID
     * HungHLP 15-11-2023
     * @throws Exception
     */

    @Test
    public void findAll_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/recommend"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * list friend recommend
     * Param accountID
     * HungHLP 15-11-2023
     * @throws Exception
     */
    @Test
    public void findAll_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/recommend"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].nameAccount").value("Kaka"))
                .andExpect(jsonPath("$[0].nameGender").value("male"))
                .andExpect(jsonPath("$[0].avatarAccount").value("https://allimages.sgp1.digitaloceanspaces.com/tipeduvn/2022/08/1661163206_695_Tuyen-tap-hinh-nen-Kaka-full-HD-dep-khong-the.jpg"))
                .andExpect(jsonPath("$[0].nameLocation").value("Hà Nội"))
                .andExpect(jsonPath("$[0].jobAccount").value("doctor"))
                .andExpect(jsonPath("$[0].hobbyAccount").value("music"));

    }
}
