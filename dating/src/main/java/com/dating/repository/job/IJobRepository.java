package com.dating.repository.job;

import com.dating.model.hobby.Hobby;
import com.dating.model.job.Job;
import org.jvnet.staxex.BinaryText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IJobRepository extends JpaRepository<Job, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM jobs", nativeQuery = true)
    List<Job> getAllBy();

}
