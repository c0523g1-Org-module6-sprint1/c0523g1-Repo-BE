package com.dating.dto.GiftRecordDto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GiftRecordDto implements Validator {


    @NotNull
    @Min(1)
    private Integer quantity;

    private Integer giftId;

    private String accountSenderId;

    private String accountReceiverId;

    public GiftRecordDto() {
    }

    public GiftRecordDto(Integer quantity, Integer giftId, String accountSenderId, String accountReceiverId) {
        this.quantity = quantity;
        this.giftId = giftId;
        this.accountSenderId = accountSenderId;
        this.accountReceiverId = accountReceiverId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public String getAccountSenderId() {
        return accountSenderId;
    }

    public void setAccountSenderId(String accountSenderId) {
        this.accountSenderId = accountSenderId;
    }

    public String getAccountReceiverId() {
        return accountReceiverId;
    }

    public void setAccountReceiverId(String accountReceiverId) {
        this.accountReceiverId = accountReceiverId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
