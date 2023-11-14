package com.dating.HauNH_controller.gift;

import com.dating.model.gift.Gift;
import com.dating.model.gift.GiftRecord;

import com.dating.service.giftService.IGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/gift")
public class GiftController {
    @Autowired
    private IGiftService iGiftService;
    @GetMapping("")
    public ResponseEntity<List<Gift>> getAll(){
     List<Gift> list = iGiftService.getAll();
     if (list == null) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }else {
         return new ResponseEntity<>(list,HttpStatus.OK);
     }
    }
    @GetMapping("/addGift")
    public  ResponseEntity<String> addGift(@RequestBody GiftRecord giftRecord){
        GiftRecord giftRecord1 = new GiftRecord();
        Principal principal;
//        giftRecord1.setAccountSender(principal.);
    iGiftService.add(giftRecord);
      return ResponseEntity.ok("tặng thành công!");
    }
}
