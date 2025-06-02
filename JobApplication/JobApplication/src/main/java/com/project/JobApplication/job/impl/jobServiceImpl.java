package com.project.JobApplication.job.impl;

import com.project.JobApplication.job.Job;
import com.project.JobApplication.job.JobRepository;
import com.project.JobApplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class jobServiceImpl implements JobService {
    //private List<Job> jobs=new ArrayList<>();
    JobRepository jobRepository;
    private long nextId=1L;

    public jobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findall() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJobById(long id) {
        try{
        jobRepository.deleteById(id);
        return true;
        }catch (Exception e){
            return false;
        }

    }

    public Boolean updateJob(long id,Job updatedJob){
        Optional<Job> jobOptional=jobRepository.findById(id);

            if (jobOptional.isPresent()){
                Job job=jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }

        return false;
    }


}
