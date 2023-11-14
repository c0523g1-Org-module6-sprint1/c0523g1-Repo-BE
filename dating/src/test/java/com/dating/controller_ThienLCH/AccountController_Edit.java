package com.dating.controller_ThienLCH;

import com.dating.dto.account.AccountDto;
import com.dating.model.Role;
import com.dating.model.location.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountController_Edit {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void editAccount_name_2() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setName("");
        accountDto.setBirthday("2000-10-07");
        accountDto.setAvatar("link firebase");
        accountDto.setLocationId(3);
        accountDto.setJobId(3);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/admin/edit/{id}"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void editAccount_name_4() throws Exception {

        AccountDto accountDto = new AccountDto();
        accountDto.setName("Hoan Thien");
        accountDto.setBirthday("1997-10-07");
        accountDto.setAvatar("link firebase-01");
        accountDto.setLocationId(2);
        accountDto.setJobId(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/admin/edit/{id}")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
