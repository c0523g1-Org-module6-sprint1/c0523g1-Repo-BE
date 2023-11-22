package com.dating.service.relationship;

import com.dating.dto.relationship.IFriendDto;
import com.dating.repository.relationship.IRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService implements IFriendService{
    @Autowired
    private IRelationshipRepository iRelationshipRepository;
    @Override
    public List<IFriendDto> findAllFriendByName(Integer idLogin,String name) {
        return iRelationshipRepository.findAllFriendByName(idLogin,name);
    }

    @Override
    public void blockFriend(Integer idLogin, Integer idFriend) {
        iRelationshipRepository.blockFriend(idLogin,idFriend);
    }

    @Override
    public void unFriend(Integer idLogin, Integer idFriend) {
        iRelationshipRepository.unFriend(idLogin,idFriend);
    }

    @Override
    public void unblockFriend(Integer idLogin, Integer idFriend) {
        iRelationshipRepository.unblockFriend(idLogin,idFriend);
    }
}
