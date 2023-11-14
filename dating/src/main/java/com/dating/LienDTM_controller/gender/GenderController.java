package com.dating.controller.gender;

import com.dating.model.gender.Gender;
import com.dating.model.job.Job;
import com.dating.service.gender.IGenderService;
import com.dating.service.job.IJobService;
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
@RequestMapping("/api/genders")
public class GenderController {
    @Autowired
    private IGenderService genderService;
    @GetMapping("")
    public ResponseEntity<List<Gender>> getAll(){
        List<Gender> genders = genderService.getAll();
        if(genders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(genders,HttpStatus.OK);
        }
    }
}
