package com.dating.service.relationship;

import com.dating.dto.friend.IFriendDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFriendService {
    List<IFriendDto> findAllFriendByName(String name);
    void blockFriend(Integer idLogin,Integer idFriend);
    void unFriend(Integer idLogin,Integer idFriend);
}
