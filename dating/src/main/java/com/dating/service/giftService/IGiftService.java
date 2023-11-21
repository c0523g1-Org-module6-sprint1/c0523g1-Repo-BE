package com.dating.service.giftService;

import com.dating.dto.GiftRecordDto.GiftRecordDto;
import com.dating.model.gift.Gift;
import com.dating.model.gift.GiftRecord;

import java.util.List;

public interface IGiftService {
    List<Gift> getAll();

    void add( int quantity,Integer accountReceiver,Integer accountSender, int gift);

    int findPrice(int id);

    double sum(int quantity, int gift);

    List<GiftRecord> getListRecord(Integer accountId);
}
