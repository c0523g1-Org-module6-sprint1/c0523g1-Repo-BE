package com.dating.SangPQ_controller;

import com.dating.dto.account.AccountDto;
import com.dating.model.gender.Gender;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
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
public class AccountRestController_login {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Creator: SangPQ
     * Goal: userName = null
     * @Throw: Exception
     */
    @Test
    public void register_userName_13() throws Exception{
       AccountDto accountDto = new AccountDto();
       accountDto.setUserName(null);
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
     * Goal: password = null
     * @Throw: Exception
     */
    @Test
    public void register_password_13() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setPassword(null);
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
     * Goal: birthday = null
     * @Throw: Exception
     */
    @Test
    public void register_birthday_13() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setBirthday(null);
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
     * Goal: gender = null
     * @Throw: Exception
     */
    @Test
    public void register_gender_13() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setGender(null);
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
     * Goal: job = null
     * @Throw: Exception
     */
    @Test
    public void register_job_13() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setJob(null);
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
     * Goal: location = null
     * @Throw: Exception
     */
    @Test
    public void register_location_13() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setLocation(null);
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
     * Goal: email = null
     * @Throw: Exception
     */
    @Test
    public void register_email_13() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setEmail(null);
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
     * Goal: userName = ""
     * @Throw: Exception
     */
    @Test
    public void register_userName_14() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setUserName("");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/register")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: SangPQ
     * Goal: password = ""
     * @Throw: Exception
     */
    @Test
    public void register_password_14() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setPassword("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: SangPQ
     * Goal: birthday = ""
     * @Throw: Exception
     */
    @Test
    public void register_birthday_14() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setBirthday("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: SangPQ
     * Goal: gender = ""
     * @Throw: Exception
     */
    @Test
    public void register_gender_14() throws Exception{
        AccountDto accountDto = new AccountDto();
        Gender gender = new Gender();
        gender.setId(1);
        gender.setName("");
        accountDto.setGender(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: SangPQ
     * Goal: job = ""
     * @Throw: Exception
     */
    @Test
    public void register_job_14() throws Exception{
        AccountDto accountDto = new AccountDto();
        Job job = new Job();
        job.setId(1);
        job.setName("");
        accountDto.setJob(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: SangPQ
     * Goal: location = ""
     * @Throw: Exception
     */
    @Test
    public void register_location_14() throws Exception{
        AccountDto accountDto = new AccountDto();
//        Location location = new Location();
//        location.setId(1);
//        location.setName("");
        accountDto.setLocation(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: SangPQ
     * Goal: email = ""
     * @Throw: Exception
     */
    @Test
    public void register_email_14() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setEmail("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: SangPQ
     * Goal: userName = maxlength
     * @Throw: Exception
     */
    @Test
    public void register_userName_17() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setUserName("phanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsang");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/register")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: SangPQ
     * Goal: userName = minlength
     * @Throw: Exception
     */
    @Test
    public void register_userName_16() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setUserName("sang");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: SangPQ
     * Goal: password = maxlength
     * @Throw: Exception
     */
    @Test
    public void register_password_17() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setPassword("phanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsang");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: SangPQ
     * Goal: password = minlength
     * @Throw: Exception
     */
    @Test
    public void register_password_16() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setPassword("sang");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Creator: SangPQ
     * Goal: email = maxlength
     * @Throw: Exception
     */
    @Test
    public void register_email_17() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setEmail("phanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsangphanquocsang");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/user/register")
                                .content(this.objectMapper.writeValueAsString(accountDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: SangPQ
     * Goal: email = minlength
     * @Throw: Exception
     */
    @Test
    public void register_email_16() throws Exception{
        AccountDto accountDto = new AccountDto();
        accountDto.setEmail("sang");
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
