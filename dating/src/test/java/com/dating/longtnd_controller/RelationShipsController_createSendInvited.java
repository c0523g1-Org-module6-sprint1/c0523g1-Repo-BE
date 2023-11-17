package com.dating.longtnd_controller;

import com.dating.dto.relationships.AccountDTO;
import com.dating.dto.relationships.RelationshipsDTO;
import com.dating.model.Role;
import com.dating.model.account.Account;
import com.dating.model.gender.Gender;
import com.dating.model.hobby.Hobby;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import com.dating.model.message.MessageStatus;
import com.dating.model.relationship.RelationshipStatus;
import com.dating.model.relationship.Relationships;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RelationShipsController_createSendInvited {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Check case SenderAccount value valid
     *
     * @throws Exception Create LongTND
     *                   Date 14/10/2023
     */

    @Test
    public void saveInviteFriend_sendAccountID_18() throws Exception {
        RelationshipsDTO relationshipsDTO = new RelationshipsDTO();

        AccountDTO sendAccountDTO = new AccountDTO();
        sendAccountDTO.setId(1);
        relationshipsDTO.setSendAccount(sendAccountDTO);

        AccountDTO receiverAccountDTO = new AccountDTO();
        receiverAccountDTO.setId(3);
        relationshipsDTO.setReceiverAccount(receiverAccountDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/sent-invite/")
                        .content(this.objectMapper.writeValueAsString(relationshipsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Check case relationships value null
     *
     * @throws Exception Create LongTND
     *                   Date 14/10/2023
     */
    @Test
    public void saveInviteFriend_sendAccountID_13() throws Exception {
        RelationshipsDTO relationshipsDTO = null;

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/sent-invite/")
                        .content(this.objectMapper.writeValueAsString(relationshipsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case relationships value empty
     *
     * @throws Exception Create LongTND
     *                   Date 14/11/2023
     */

    @Test
    public void saveInviteFriend_sendAccountID_14() throws Exception {
            RelationshipsDTO relationshipsDTO = new RelationshipsDTO();
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/sent-invite/")
                        .content(this.objectMapper.writeValueAsString(relationshipsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case accountID value empty
     * @throws Exception
     * Create By LongTND
     * Date 14/11/2023
     */
    @Test
    public void getAccountByID_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/personal-page/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Check case accountID value haven't in database
      * @throws Exception
      * Create By LongTND
      * Date 14/11/2023
     */
    @Test void getAccountByID_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/personal-page/{id}",9))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Check case accountID value valid
     * @throws Exception
     * Create by LongTND
     * Date 14/11/2023
     */

    @Test
    public void getAccountByID_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/personal-page/{id}",1  ))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("Cristiano Ronaldo"))
                .andExpect(jsonPath("avatar").value("https://wallpaperaccess.com/full/3090338.jpg"))
                .andExpect(jsonPath("birthday").value("1987-10-10"))
                .andExpect(jsonPath("email").value("ronaldo@gmail.com"))
                .andExpect(jsonPath("expire").value("2023-11-30"))
                .andExpect(jsonPath("isDeleted").value(false))
                .andExpect(jsonPath("maritalStatus").value("Đã kết hôn"))
                .andExpect(jsonPath("money").value(1000000))
                .andExpect(jsonPath("password").value("123456"))
                .andExpect(jsonPath("phoneNumber").value("0932533481"))
                .andExpect(jsonPath("point").value(100))
                .andExpect(jsonPath("regisDate").value("2023-10-10"))
                .andExpect(jsonPath("userName").value("ronaldo123"))
                .andExpect(jsonPath("gender.id").value(1))
                .andExpect(jsonPath("job.id").value(1))
                .andExpect(jsonPath("location.id").value(1))
                .andExpect(jsonPath("messageStatus.id").value(1))
                .andExpect(jsonPath("role.id").value(2));
    }

}
