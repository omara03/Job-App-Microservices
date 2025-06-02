package com.Project1.jobms.job.dto;

import com.Project1.jobms.job.Job;
import com.Project1.jobms.job.external.Company;


public class JobWithCompanyDTO {
    private Job job;
    private Company company;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
