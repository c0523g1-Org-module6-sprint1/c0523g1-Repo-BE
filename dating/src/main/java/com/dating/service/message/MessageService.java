package com.dating.service.message;

import com.dating.model.account.Account;
import com.dating.model.message.Messages;
import com.dating.model.relationship.Relationships;
import com.dating.repository.message.IMessageAccountRepository;
import com.dating.repository.message.IMessageRelationshipRepository;
import com.dating.repository.message.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService implements IMessageService{
    @Autowired
    private IMessageRepository messageRepository;
    @Autowired
    private IMessageAccountRepository messageAccountRepository;
    @Autowired
    private IMessageRelationshipRepository messageRelationshipRepository;

    @Override
    public Account findAccountById(Integer id) {
        return messageAccountRepository.selectAccountById(id);
    }

    @Override
    public List<Messages> getMessage(Integer accountId) {
        return messageRepository.findMessageByAccountId(accountId);
    }

    @Override
    public List<Account> getFriendList(Integer accountId) {
        List<Relationships> relationships = messageRelationshipRepository.findFriendListByAccountId(accountId);
        List<Account> result = new ArrayList<>();
        for (Relationships value : relationships) {
            if (value.getSenderAccount().getId() == accountId) {
                result.add(value.getReceiverAccount());
            } else {
                result.add(value.getSenderAccount());
            }
        }
        return result;
    }

    @Override
    public List<Messages> getUnknowList(Integer accountId) {
        List<Account> friendList = getFriendList(accountId);
        List<Messages> messagesList = getMessage(accountId);
        List<Messages> unknowmess = new ArrayList<>();
        for (Messages messages : messagesList){
            if (!friendList.contains(messages.getSenderAccount()) && (messages.getSenderAccount().getId() != accountId)){
                unknowmess.add(messages);
            }
        }
        return unknowmess;
    }

    @Override
    public void setBusy(Boolean isBusy, Integer accountId) {
        Account account = findAccountById(accountId);
        if (account != null) {
            if (isBusy) {
                messageAccountRepository.setBusy(2, accountId);
            } else {
                messageAccountRepository.setBusy(1, accountId);
            }
        }
    }

    @Override
    public Messages createMessage(Integer ownAccountId, Integer friendAccountId) {
        String path;
        if (ownAccountId < friendAccountId) {
            path = "mess-" + ownAccountId + "-" + friendAccountId;
        } else {
            path = "mess-" + friendAccountId + "-" + ownAccountId;
        }
        messageRepository.createMessage(ownAccountId, friendAccountId, path);
        Messages newMess = messageRepository.getLastMess();
        return newMess;
    }

    @Override
    public void deleteMessage(Integer messagesId) {
        if (getMessageById(messagesId) != null){
            messageRepository.delMessage(messagesId);
        }
    }

    @Override
    public Messages getMessageById(Integer messageId) {
        return messageRepository.getMessageById(messageId);
    }

    @Override
    public Messages getMessageByAccountId(Integer ownAccountId, Integer friendAccountId) {
        Messages messagesList = messageRepository.isContacted(ownAccountId, friendAccountId);
        return messagesList;
    }

}
