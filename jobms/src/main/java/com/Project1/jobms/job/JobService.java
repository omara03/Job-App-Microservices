package com.Project1.jobms.job;

import com.Project1.jobms.job.dto.JobWithCompanyDTO;

import java.util.List;

public interface JobService {
    List<JobWithCompanyDTO> findall();
    void createJob(Job job);
    Job getJobById(long id);
    Boolean deleteJobById(long id);
    Boolean updateJob(long id,Job updatedJob);
}
