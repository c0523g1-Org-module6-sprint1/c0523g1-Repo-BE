package com.dating.service.giftService;

import com.dating.model.gift.Gift;
import com.dating.model.gift.GiftRecord;

import java.util.List;

public interface IGiftService {
    List<Gift> getAll();

    void add(GiftRecord giftRecord);
}
