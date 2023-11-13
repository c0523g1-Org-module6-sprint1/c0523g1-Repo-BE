package com.dating.service.relationship;

import com.dating.dto.IFriendDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFriendService {
    List<IFriendDto> findAllFriendByName(String name);
}
