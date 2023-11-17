package com.dating.dto.GiftRecordDto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GiftRecordDto implements Validator {


    @NotNull
    @Min(1)
    private Integer quantity;
    @NotNull
    private Integer giftId;
    @NotNull
    private Integer accountSenderId;
    @NotNull
    private Integer accountReceiverId;

    public GiftRecordDto() {
    }

    public GiftRecordDto(Integer quantity, Integer giftId, Integer accountSenderId, Integer accountReceiverId) {
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

    public Integer getAccountSenderId() {
        return accountSenderId;
    }

    public void setAccountSenderId(Integer accountSenderId) {
        this.accountSenderId = accountSenderId;
    }

    public Integer getAccountReceiverId() {
        return accountReceiverId;
    }

    public void setAccountReceiverId(Integer accountReceiverId) {
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
