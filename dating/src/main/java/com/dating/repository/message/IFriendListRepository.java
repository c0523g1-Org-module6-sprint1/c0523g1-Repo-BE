package com.dating.repository.message;

import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFriendListRepository extends JpaRepository<Account, Integer> {
//    List<Account> findAccountsByRelationshipsSet_SenderAccount_IdOrRelationshipsSet_ReceiverAccountAndGender_Id(Integer senderId, Integer receiverId);
}
