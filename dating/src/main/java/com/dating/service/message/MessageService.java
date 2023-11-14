package com.dating.service.message;

import com.dating.model.account.Account;
import com.dating.model.message.MessageStatus;
import com.dating.model.message.Messages;
import com.dating.repository.message.IFriendListRepository;
import com.dating.repository.message.IMessageRepository;
import com.dating.repository.message.IMessageStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService{
//    @Autowired
//    private IMessageRepository messageRepository;
//    @Autowired
//    private IMessageStatusRepository messageStatusRepository;
//    @Autowired
//    private IFriendListRepository friendListRepository;
//
//    @Override
//    public List<Messages> getMessage(Integer accountId) {
//        List<Messages> messagesList = messageRepository.findMessagesBySenderAccount_IdOrReceiverAccount_Id(accountId, accountId);
//        return messagesList;
//    }
//
//    @Override
//    public List<Account> getFriendList(Integer accountId) {
//        List<Account> friendList = friendListRepository.findAccountsByRelationshipsSet_SenderAccount_IdOrRelationshipsSet_ReceiverAccountAndGender_Id(accountId, accountId);
//        return friendList;
//    }
//
//    @Override
//    public void setBusy(Boolean isBusy, Integer accountId) {
//        Account account = friendListRepository.findById(accountId).get();
//        MessageStatus online = messageStatusRepository.findById(0).get();
//        MessageStatus busy = messageStatusRepository.findById(1).get();
//
//        if (isBusy) {
//            account.setMessageStatus(busy);
//        } else {
//            account.setMessageStatus(online);
//        }
//    }
//
//    @Override
//    public void createMessage(Messages messages) {
//        messages.setDeleted(false);
//        messageRepository.save(messages);
//    }
}
