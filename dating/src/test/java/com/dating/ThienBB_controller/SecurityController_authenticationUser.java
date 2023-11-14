package com.dating.ThienBB_controller;

import com.dating.payload.request.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityController_authenticationUser {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Creator: ThienBB
     * Date created: 14/11/2023
     * Goal: LoginRequest = null
     *
     * @Throw: Exception
     */
    @Test
    public void authenticationUser_invalidUser_13() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/public/login")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(401));
    }

    /**
     * Creator: ThienBB
     * Date created: 14/11/2023
     * Goal: LoginRequest is invalid
     *
     * @Throw: Exception
     */
    @Test
    public void authenticationUser_invalidUser_14() throws Exception {
        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setUsername("");
        loginRequest.setPassword("");

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/public/login")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(403));
    }

    /**
     * Creator: ThienBB
     * Date created: 14/11/2023
     * Goal: LoginRequest is valid and user has role admin
     *
     * @Throw: Exception
     */
    @Test
    public void authenticationUser_validUserWithRoleAdmin_18() throws Exception {
        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setUsername("admin");
        loginRequest.setPassword("123456");

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/public/login")
                                .contentType(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(200));
    }

    /**
     * Creator: ThienBB
     * Date created: 14/11/2023
     * Goal: LoginRequest is valid and user has role member
     *
     * @Throw: Exception
     */
    @Test
    public void authenticationUser_validUserWithRoleMember_18() throws Exception {
        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setUsername("user");
        loginRequest.setPassword("123456");

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/public/login")
                                .contentType(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(200));
    }

}