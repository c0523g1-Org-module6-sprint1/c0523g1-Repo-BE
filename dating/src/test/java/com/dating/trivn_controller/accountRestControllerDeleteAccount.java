package com.dating.trivn_controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class accountRestControllerDeleteAccount {
    private MockMvc mockMvc;

    /**
     * TriVN
     * id = null
     * @throws Exception
     */
    @Test
    public void lockAccount_id() throws Exception {
        Long id = null;
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/accounts/{id}", id))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * TriVN
     * id = ""
     * @throws Exception
     */
    @Test
    public void lockAccount_id_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/accounts/{id}", ""))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

}
