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

    /**
     * method getMessage
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer messageId
     * return new Object: List<Messages>
     */
    @Override
    public List<Messages> getMessage(Integer accountId) {

        return messageRepository.findMessageByAccountId(accountId);
    }

    /**
     * method getFriendList
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer accountId, String searchName
     * return new Object: List<Account>
     */
    @Override
    public List<Account> getFriendList(Integer accountId, String name) {
        String searchName = "%" + name + "%";
        List<Account> result = messageAccountRepository.getFriendList(accountId, searchName);
        return result;
    }

    /**
     * method getUnknowList
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer accountId, String searchName
     * return new Object: List<Account>
     */
    @Override
    public List<Account> getUnknowList(Integer accountId, String name) {
        String searchName = "%" + name + "%";
        List<Account> result = messageAccountRepository.getUnknowList(accountId, searchName);
        return result;

    }

    /**
     * method setBusy
     * Create ThangLQ
     * Date 13-11-2023
     * param Boolean isBusy, Integer accountId
     * return new Object: void
     */
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

    /**
     * method createMessage
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer ownAccountId, Integer friendAccountId
     * return new Object: Messages
     */
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

    /**
     * method deleteMessage
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer messagesId
     * return new Object: void
     */
    @Override
    public void deleteMessage(Integer messagesId) {
        if (getMessageById(messagesId) != null){
            messageRepository.delMessage(messagesId);
        }
    }

    /**
     * method getMessageById
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer messagesId
     * return new Object: Messages
     */
    @Override
    public Messages getMessageById(Integer messageId) {
        return messageRepository.getMessageById(messageId);
    }

    /**
     * method getMessageByAccountId
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer ownAccountId, Integer friendAccountId
     * return new Object: Messages
     */
    @Override
    public Messages getMessageByAccountId(Integer ownAccountId, Integer friendAccountId) {
        Messages messagesList = messageRepository.isContacted(ownAccountId, friendAccountId);
        return messagesList;
    }
}
