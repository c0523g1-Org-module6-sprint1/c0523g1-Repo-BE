package com.dating.dto;
import com.dating.model.account.Account;
public class MessageDto {
    private String path;
    private Boolean isDeleted;
    private Account senderAccount;
    private Account receiverAccount;

    public MessageDto() {
    }

    public MessageDto(String path, Boolean isDeleted, Account senderAccount, Account receiverAccount) {
        this.path = path;
        this.isDeleted = isDeleted;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }
}
