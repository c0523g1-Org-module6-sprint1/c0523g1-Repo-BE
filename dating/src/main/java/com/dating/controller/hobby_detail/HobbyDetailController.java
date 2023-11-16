package com.dating.controller.hobby_detail;

import com.dating.model.hobby_detail.HobbyDetail;
import com.dating.service.hobby_detail.IHobbyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/hobbyDetails")
public class HobbyDetailController {
    @Autowired
    private IHobbyDetailService hobbyDetailService;
    @GetMapping("")
    public ResponseEntity<List<HobbyDetail>> getAll(){
        List<HobbyDetail> hobbyDetails = hobbyDetailService.getAll();
        if(hobbyDetails.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(hobbyDetails,HttpStatus.OK);
        }
    }
}
