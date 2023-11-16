package com.dating.longtnd_controller;

import com.dating.dto.relationships.AccountDTO;
import com.dating.dto.relationships.RelationshipsDTO;
import com.dating.model.account.Account;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class RelationShipsController_createSendInvited {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Check case SenderAccount value null
     * @throws Exception
     * Create LongTND
     * Date 14/10/2023
     */

    @Test
    public void saveInviteFriend_sendAccountID_14() throws Exception {
        RelationshipsDTO relationshipsDTO = new RelationshipsDTO();

        AccountDTO sendAccountDTO = new AccountDTO();
        sendAccountDTO.setId(1);
        relationshipsDTO.setSendAccount(sendAccountDTO);

        AccountDTO receiverAccountDTO = new AccountDTO();
        receiverAccountDTO.setId(2);
        relationshipsDTO.setReceiverAccount(receiverAccountDTO);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/sent-invite/")
                        .content(this.objectMapper.writeValueAsString(relationshipsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
