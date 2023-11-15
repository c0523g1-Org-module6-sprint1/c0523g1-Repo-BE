package com.dating.SangPQ_controller;

import com.dating.dto.account.AccountDto;
import com.dating.model.account.Account;
import com.dating.model.gender.Gender;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_login {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Creator: SangPQ
     * Goal: account = null
     * @Throw: Exception
     */
    @Test
    public void register_object_13() throws Exception{
       AccountDto accountDto = null;
       this.mockMvc.perform(
               MockMvcRequestBuilders
                       .post("/api/user/register")
                       .content(this.objectMapper.writeValueAsString(null))
                       .contentType(MediaType.APPLICATION_JSON_VALUE))
               .andDo(print())
               .andExpect(status().is4xxClientError());

    }
    /**
     * Creator: SangPQ
     * Goal: account = ""
     * @Throw: Exception
     */
    @Test
    public void register_object_14() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setUserName("");
        accountDto.setPassword("");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/register")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    /**
//     * Creator: SangPQ
//     * Goal: all information valid => register success
//     * @Throw: Exception
//     */
//    @Test
//    public void register_object_18() throws Exception{
//        AccountDto accountDto = new AccountDto();
//        accountDto.setUserName("hanhntm");
//        accountDto.setPassword("123456");
//        accountDto.setBirthday("1990-01-01");
//        Gender gender = new Gender();
//        gender.setId(2);
//        gender.setName("Nữ");
//        accountDto.setGender(gender);
//        Job job = new Job();
//        job.setId(1);
//        job.setName("IT");
//        accountDto.setJob(job);
//        Location location = new Location();
//        location.setId(1);
//        location.setName("ĐN");
//        accountDto.setLocation(location);
//        accountDto.setEmail("myhanh@gmail.com");
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/api/user/register")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
}
