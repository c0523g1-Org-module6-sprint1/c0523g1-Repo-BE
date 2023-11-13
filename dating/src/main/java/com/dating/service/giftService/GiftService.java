package com.dating.service.giftService;

import com.dating.model.gift.Gift;
import com.dating.model.gift.GiftRecord;
import com.dating.repository.Gift.IGiftRecordRepository;
import com.dating.repository.Gift.IGiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService implements IGiftService{
    @Autowired
    private IGiftRepository iGiftRepository;
    @Autowired
    private IGiftRecordRepository iGiftRecordRepository;
    @Override
    public List<Gift> getAll() {
        return iGiftRepository.getAll();
    }

    @Override
    public void add(GiftRecord giftRecord) {
        iGiftRecordRepository.crate(giftRecord);
    }
}
