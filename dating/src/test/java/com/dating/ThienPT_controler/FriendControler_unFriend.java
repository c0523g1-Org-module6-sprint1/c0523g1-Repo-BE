package com.dating.ThienPT_controler;

import com.dating.dto.relationship.FriendBlockDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class FriendControler_unFriend {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * author: ThienPT
     * date : 16/11/2023
     * goal: Check case unfriend when idLogin is null
     * with [idLogin] = null
     *
     * @throws Exception
     * */

    @Test
    void unFriend_idLogin_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/friend/unfriend")
                                .param("idFriend", String.valueOf(3)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    /**
     * author: ThienPT
     * date : 16/11/2023
     * goal: Check case unfriend when idFriend is null
     * with [idFriend] = null
     *
     * @throws Exception
     * */

    @Test
    void unFriend_idFriend_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/friend/unfriend")
                                .param("idLogin", String.valueOf(1)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    /**
     * author: ThienPT
     * date : 16/11/2023
     * goal: Check case unfriend when idLogin not found in database
     * with [idLogin] not found in database
     *
     * @throws Exception
     * */

    @Test
    void unFriend_idLogin_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/friend/unfriend")
                                .param("idLogin", String.valueOf(1000))
                                .param("idFriend", String.valueOf(3)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    /**
     * author: ThienPT
     * date : 16/11/2023
     * goal: Check case unfriend when idFriend not found in database
     * with [idFriend] not found in database
     *
     * @throws Exception
     * */

    @Test
    void unFriend_idFriend_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/friend/unfriend")
                                .param("idLogin", String.valueOf(1))
                                .param("idFriend", String.valueOf(30000)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    /**
     * author: ThienPT
     * date : 16/11/2023
     * goal: Check case unfriend when idLogin can find in database
     * with [idLogin] exist in database
     *
     * @throws Exception
     * */

    @Test
    void unFriend_idLogin_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/friend/unfriend")
                                .param("idLogin", String.valueOf(1))
                                .param("idFriend", String.valueOf(3)))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * author: ThienPT
     * date : 16/11/2023
     * goal: Check case unfriend when idFriend can find in database
     * with [idFriend] exist in database
     *
     * @throws Exception
     * */

    @Test
    void unFriend_idFriend_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/friend/unfriend")
                                .param("idLogin", String.valueOf(1))
                                .param("idFriend", String.valueOf(3)))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

}