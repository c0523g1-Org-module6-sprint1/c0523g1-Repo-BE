package com.dating.service.job;

import com.dating.model.job.Job;
import com.dating.repository.job.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService implements IJobService{
    @Autowired
    private IJobRepository jobRepository;


    @Override
    public List<Job> getAll() {
        return jobRepository.getAllBy();
    }
}
