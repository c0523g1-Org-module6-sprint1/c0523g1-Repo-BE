package com.dating.service.message;
import com.dating.model.account.Account;
import com.dating.model.message.Messages;
import java.util.List;

public interface IMessageService {
    Account findAccountById(Integer id);
    List<Messages> getMessage(Integer accountId);
    List<Account> getFriendList(Integer accountId, String name);
    List<Account> getUnknowList(Integer accountId, String name);
    void setBusy(Boolean isBusy, Integer accountId);
    Messages createMessage (Integer ownAccountId, Integer friendAccountId);
    void deleteMessage (Integer messagesId);
    Messages getMessageById (Integer messageId);
    Messages getMessageByAccountId (Integer ownAccountId, Integer friendAccountId);

}
