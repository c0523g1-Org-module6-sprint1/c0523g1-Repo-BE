package com.dating.repository.job;

import com.dating.model.hobby.Hobby;
import com.dating.model.job.Job;
import org.jvnet.staxex.BinaryText;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobRepository extends JpaRepository<Job, Integer> {
    List<Job> getAllBy();

}
