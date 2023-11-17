package com.dating.HauNH_controller;

import com.dating.model.account.Account;
import com.dating.model.update_account.AccountTypes;
import com.dating.model.update_account.PackageDetail;
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
public class PackageDetailRestController_update {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void setAccountTypes_24() throws Exception {

        PackageDetail packageDetail = new PackageDetail();
        AccountTypes accountTypes = new AccountTypes();
        accountTypes.setId(3);
        packageDetail.setAccountTypes(accountTypes);

        Account account = new Account();
        account.setId(2);
        packageDetail.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/packageDetail/setAccountTypes/2/3")
                        .content(this.objectMapper.writeValueAsString(packageDetail))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void setMoneyAccount_24() throws Exception {
        PackageDetail packageDetail = new PackageDetail();
        AccountTypes accountTypes = new AccountTypes();
        accountTypes.setId(3);
        packageDetail.setAccountTypes(accountTypes);

        Account account = new Account();
        account.setId(2);
        packageDetail.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/packageDetail/setMoneyAccount/2/60000")
                        .content(this.objectMapper.writeValueAsString(packageDetail))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}