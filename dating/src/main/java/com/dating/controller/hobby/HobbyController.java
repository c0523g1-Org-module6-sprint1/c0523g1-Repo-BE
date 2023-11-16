package com.dating.controller.hobby;

import com.dating.model.hobby.Hobby;
import com.dating.model.job.Job;
import com.dating.service.hobby.IHobbyService;
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
@RequestMapping("/api/hobby")
public class HobbyController {
    @Autowired
    private IHobbyService hobbyService;
    @GetMapping("")
    public ResponseEntity<List<Hobby>> getAll(){
        List<Hobby> hobbies = hobbyService.getAll();
        if(hobbies.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(hobbies,HttpStatus.OK);
        }
    }
}
