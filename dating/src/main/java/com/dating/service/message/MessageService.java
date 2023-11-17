package com.dating.service.message;

import com.dating.model.account.Account;
import com.dating.model.message.Messages;
import com.dating.repository.message.IMessageAccountRepository;
import com.dating.repository.message.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService implements IMessageService{
    @Autowired
    private IMessageRepository messageRepository;
    @Autowired
    private IMessageAccountRepository messageAccountRepository;

    @Override
    public Account findAccountById(Integer id) {
        return messageAccountRepository.selectAccountById(id);
    }

    @Override
    public List<Messages> getMessage(Integer accountId) {

        return messageRepository.findMessageByAccountId(accountId);
    }

    @Override
    public List<Account> getFriendList(Integer accountId, String name) {
        String searchName = "%" + name + "%";
        List<Account> result = messageAccountRepository.getFriendList(accountId, searchName);
        return result;
    }

    @Override
    public List<Account> getUnknowList(Integer accountId, String name) {
        String searchName = "%" + name + "%";
        List<Account> result = messageAccountRepository.getUnknowList(accountId, searchName);
        return result;

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
        String path = "mess-" + friendAccountId + "-" + ownAccountId;
        if (ownAccountId < friendAccountId) {
            path = "mess-" + ownAccountId + "-" + friendAccountId;
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
