package com.project.JobApplication.job;

import java.util.List;

public interface JobService {
    List<Job> findall();
    void createJob(Job job);
    Job getJobById(long id);
    Boolean deleteJobById(long id);
    Boolean updateJob(long id,Job updatedJob);
}
