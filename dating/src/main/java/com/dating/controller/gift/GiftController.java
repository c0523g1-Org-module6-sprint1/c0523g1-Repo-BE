package com.dating.controller.gift;

import com.dating.dto.GiftRecordDto.GiftRecordDto;
import com.dating.model.account.Account;
import com.dating.model.gift.Gift;

import com.dating.model.gift.GiftRecord;
import com.dating.service.account.IChangePasswordService;
import com.dating.service.giftService.IGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/gift")
public class GiftController {
    @Autowired
    private IGiftService iGiftService;
    @Autowired
    private IChangePasswordService iChangePasswordService;


    /**
     * method getAll
     * Create QuyNP
     * Date 13-11-2023
     * return List<Gift>
     */
    @GetMapping("")
    public ResponseEntity<List<Gift>> getAll() {
        List<Gift> list = iGiftService.getAll();
//        List<Gift> list = new ArrayList<>();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }


    /**
     * method GiveAGift
     * Create QuyNP
     * Date 13-11-2023
     */

    @PostMapping("/addGift")
    public ResponseEntity<String> giveAGift(@RequestBody @Valid  GiftRecordDto giftRecordDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("không tìm tìm thấy");
        }
        String nameReceiver = String.valueOf(giftRecordDto.getAccountReceiverId());
        String nameSender = String.valueOf(giftRecordDto.getAccountSenderId());


        Account accountSender = iChangePasswordService.findPassword(nameSender);
        Account accountReceiver = iChangePasswordService.findPassword(nameReceiver);
        if (accountSender == null || accountReceiver == null) {
            return ResponseEntity.badRequest().body("ko tìm thấy account");

        }
        // tìm giá
        int price = iGiftService.findPrice(giftRecordDto.getGiftId());

//        50
        // tính tiền
        double money = iGiftService.sum(giftRecordDto.getQuantity(), price);
        // trừ tiền
        boolean flag =  iChangePasswordService.updateMoney(money,accountSender.getUserName() );
        if (flag == false) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Không đủ tiền để thực hiện giao dịch");
        }
        int resultPoint = price * giftRecordDto.getQuantity();

        // give point
        iChangePasswordService.giftPoint(accountSender.getUserName(),resultPoint);
        iGiftService.add(giftRecordDto.getQuantity(),accountReceiver.getId(),accountSender.getId(),giftRecordDto.getGiftId());
        return ResponseEntity.ok("tặng thành công!");
    }


    /**
     * method getMoney
     * Create QuyNP
     * Date 13-11-2023
     */
    @GetMapping("/getMoney/{userName}")
    public ResponseEntity<?> getMoney(@PathVariable String userName) {
        if (userName == null || userName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Double money = iChangePasswordService.findMoney(userName);
        if (money == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(money, HttpStatus.OK);
    }
    /**
     * method getList
     * Create QuyNP
     * Date 13-11-2023
     */
    @GetMapping("getList/{userName}")
    public ResponseEntity<?> getList(@PathVariable String userName) {
        if (userName == null || userName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Account accountSender = iChangePasswordService.findPassword(userName);
        System.out.println(accountSender);
        List<GiftRecord> list = iGiftService.getListRecord(accountSender.getId());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
