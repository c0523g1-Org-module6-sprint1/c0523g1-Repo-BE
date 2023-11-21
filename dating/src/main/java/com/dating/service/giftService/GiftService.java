package com.dating.service.giftService;

import com.dating.dto.GiftRecordDto.GiftRecordDto;
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


    /**
     * method getAll
     * Create QuyNP
     * Date 13-11-2023
     * return List<Gift>
     */

    @Override
    public List<Gift> getAll() {
        return iGiftRepository.getAll();
    }

    @Override
    public void add(int quantity,Integer accountReceiver,Integer accountSender, int gift) {
        iGiftRecordRepository.insertGiftRecord(
                quantity,
                accountReceiver,
                accountSender,
                gift
        );
    }


    /**
     * method add
     * Create QuyNP
     * Date 13-11-2023
     */




    /**
     * method findGift
     * Create QuyNP
     * Date 13-11-2023
     * return int
     */
    @Override
    public int findPrice(int id) {
        return iGiftRepository.findPrice(id);
    }
    /**
     * method sum
     * Create QuyNP
     * Date 13-11-2023
     * return double
     */

    @Override
    public double sum(int quantity, int gift) {
        return quantity * gift;
    }

    @Override
    public List<GiftRecord> getListRecord(Integer accountId) {
        return iGiftRecordRepository.getAll(accountId);
    }
}
