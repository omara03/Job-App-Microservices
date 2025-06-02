package com.project.JobApplication.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.JobApplication.job.Job;
import com.project.JobApplication.review.Review;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Company {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public Company() {
    }

    public String getName() {
        return name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
