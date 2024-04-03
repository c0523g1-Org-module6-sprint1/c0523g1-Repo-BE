package com.dating.service.relationship;

import com.dating.dto.relationship.IFriendDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFriendService {
    Page<IFriendDto> findAllFriendByName(Integer idLogin, String name, Pageable pageable);
    void blockFriend(Integer idLogin,Integer idFriend);
    void unFriend(Integer idLogin,Integer idFriend);

    void unblockFriend(Integer idLogin,Integer idFriend);
}
