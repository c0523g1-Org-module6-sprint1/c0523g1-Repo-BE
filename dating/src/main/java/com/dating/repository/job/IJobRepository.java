package com.dating.repository.job;

import com.dating.model.job.Job;
import org.jvnet.staxex.BinaryText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobRepository extends JpaRepository<Job, Integer> {
}
