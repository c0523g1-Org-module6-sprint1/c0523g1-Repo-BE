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


    /**
     * method add
     * Create QuyNP
     * Date 13-11-2023
     */

    @Override
    public void add(GiftRecordDto giftRecordDto) {
        iGiftRecordRepository.insertGiftRecord(
                giftRecordDto.getQuantity(),
                giftRecordDto.getAccountReceiverId(),
                giftRecordDto.getAccountSenderId(),
                giftRecordDto.getGiftId()
        );
    }


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
}
