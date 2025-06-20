package com.Project1.jobms.job.impl;


import com.Project1.jobms.job.Job;
import com.Project1.jobms.job.JobRepository;
import com.Project1.jobms.job.JobService;
import com.Project1.jobms.job.dto.JobWithCompanyDTO;
import com.Project1.jobms.job.external.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class jobServiceImpl implements JobService {
    //private List<Job> jobs=new ArrayList<>();
    JobRepository jobRepository;
    private long nextId=1L;

    public jobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobWithCompanyDTO> findall() {
        List<Job> jobs = jobRepository.findAll();
        List<JobWithCompanyDTO> jobWithCompanyDTOs = new ArrayList<>();
        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    private JobWithCompanyDTO convertToDto(Job job) {

            JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
            jobWithCompanyDTO.setJob(job);
            RestTemplate restTemplate = new RestTemplate();
            Company company = restTemplate.getForObject("http://localhost:8081/companies/"+job.getCompanyId(), Company.class);
            jobWithCompanyDTO.setCompany(company);
            
        return jobWithCompanyDTO;

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
