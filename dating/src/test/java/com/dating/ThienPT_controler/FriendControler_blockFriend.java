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
public class FriendControler_blockFriend {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * author: ThienPT
     * date : 14/11/2023
     * goal: Check case success block friend
     * @throws Exception
     * */

    @Test
    void blockFriend_idLogin_99() throws Exception {
        FriendBlockDto friendBlockDto = new FriendBlockDto();
        friendBlockDto.setIdFriend(3);
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/public/relationship/friend/block/{idLogin}",2)
                        .content(this.objectMapper.writeValueAsString(friendBlockDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * author: ThienPT
     * date : 14/11/2023
     * goal: Check case block friend when idLogin is null
     * with [idLogin] = null
     *
     * @throws Exception
     * */

    @Test
    void blockFriend_idLogin_25() throws Exception {
        FriendBlockDto friendBlockDto = new FriendBlockDto();
        Integer idLogin = null;
        friendBlockDto.setIdFriend(3);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/relationship/friend/block/" + idLogin)
                                .content(this.objectMapper.writeValueAsString(friendBlockDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    /**
     * author: ThienPT
     * date : 14/11/2023
     * goal: Check case block friend when friendBlockDto is null
     * with [friendBlockDto] = null
     *
     * @throws Exception
     * */

    @Test
    void blockFriend_friendBlockDto_25() throws Exception {
        FriendBlockDto friendBlockDto = new FriendBlockDto();
        Integer idLogin = 1;
        friendBlockDto.setIdFriend(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/relationship/friend/block/" + idLogin)
                                .content(this.objectMapper.writeValueAsString(friendBlockDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    /**
     * author: ThienPT
     * date : 14/11/2023
     * goal: Check case block friend when idLogin not found in database
     * with [idLogin] not found in database
     *
     * @throws Exception
     * */

    @Test
    void blockFriend_idLogin_27() throws Exception {
        FriendBlockDto friendBlockDto = new FriendBlockDto();
        Integer idLogin = 1000;
        friendBlockDto.setIdFriend(3);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/relationship/friend/block/" + idLogin)
                                .content(this.objectMapper.writeValueAsString(friendBlockDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    /**
     * author: ThienPT
     * date : 14/11/2023
     * goal: Check case block friend when friendBlockDto not found in database
     * with [friendBlockDto] not found in database
     *
     * @throws Exception
     * */

    @Test
    void blockFriend_friendBlockDto_27() throws Exception {
        FriendBlockDto friendBlockDto = new FriendBlockDto();
        Integer idLogin = 1;
        friendBlockDto.setIdFriend(3000);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/relationship/friend/block/" + idLogin)
                                .content(this.objectMapper.writeValueAsString(friendBlockDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    /**
     * author: ThienPT
     * date : 14/11/2023
     * goal: Check case block friend when idLogin can find in database
     * with [idLogin] exist in database
     *
     * @throws Exception
     * */

    @Test
    void blockFriend_idLogin_28() throws Exception {
        FriendBlockDto friendBlockDto = new FriendBlockDto();
        friendBlockDto.setIdFriend(3);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/relationship/friend/block/1")
                                .content(this.objectMapper.writeValueAsString(friendBlockDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * author: ThienPT
     * date : 14/11/2023
     * goal: Check case block friend when friendBlockDto can find in database
     * with [friendBlockDto] exist in database
     *
     * @throws Exception
     * */

    @Test
    void blockFriend_friendBlockDto_28() throws Exception {
        FriendBlockDto friendBlockDto = new FriendBlockDto();
        friendBlockDto.setIdFriend(3);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/public/relationship/friend/block/1")
                                .content(this.objectMapper.writeValueAsString(friendBlockDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

}
