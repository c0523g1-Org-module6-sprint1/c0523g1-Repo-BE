package com.dating.HauNH_controller.job;

import com.dating.model.job.Job;
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
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private IJobService jobService;
    @GetMapping("")
    public ResponseEntity<List<Job>> getAll(){
        List<Job> jobs = jobService.getAll();
        if(jobs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(jobs,HttpStatus.OK);
        }
    }
}
