package com.dating.controller_ThienLCH;

import com.dating.dto.account.AccountDto;
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
public class AccountController_Edit {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: edit account with id equal ""
     * @return HttpStatus 4xx
     */
    @Test
    public void editAccount_name_1() throws Exception {
        AccountDto accountDto = new AccountDto(null, "Cristiano Ronaldo", "ronaldo123", "123456", "2023-10-10", "ronaldo@gmail.com",
                "0932533481", 1000000.0, "2023-10-10", "https://wallpaperaccess.com/full/3090338.jpg", "2023-11-30", "Đã kết hôn", 100,
                1, 1, 2, 1, 1);
        accountDto.setName("ThienLCH");
        accountDto.setBirthday("2000-10-07");
        accountDto.setAvatar("link firebase");
        accountDto.setLocationId(3);
        accountDto.setJobId(3);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/personal-page/edit/{id}", accountDto.getId()))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: edit account with id does not exist
     *
     * @return HttpStatus 4xx
     */
    @Test
    public void editAccount_name_2() throws Exception {
        AccountDto accountDto = new AccountDto(7, "Cristiano Ronaldo", "ronaldo123", "123456", "2023-10-10", "ronaldo@gmail.com",
                "0932533481", 1000000.0, "2023-10-10", "https://wallpaperaccess.com/full/3090338.jpg", "2023-11-30", "Đã kết hôn", 100,
                1, 1, 2, 1, 1);
        accountDto.setName("ThienLCH");
        accountDto.setBirthday("2000-10-07");
        accountDto.setAvatar("link firebase");
        accountDto.setLocationId(3);
        accountDto.setJobId(3);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/personal-page/edit/{id}", accountDto.getId()))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: thienlch
     * date: 14/11/2023
     * goal: edit account with real id
     *
     * @return HttpStatus 2xx
     */
    @Test
    public void editAccount_name_4() throws Exception {

        AccountDto accountDto = new AccountDto(1, "Cristiano Ronaldo", "ronaldo123", "123456", "2023-10-10", "ronaldo@gmail.com",
                "0932533481", 1000000.0, "2023-10-10", "https://wallpaperaccess.com/full/3090338.jpg", "2023-11-30", "Đã kết hôn", 100,
                1, 1, 2, 1, 1);
        accountDto.setName("Thien Smoke");
        accountDto.setAvatar("link firebase");
        accountDto.setBirthday("1997-10-10");
        accountDto.setLocationId(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/personal-page/edit/{id}", accountDto.getId())
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
