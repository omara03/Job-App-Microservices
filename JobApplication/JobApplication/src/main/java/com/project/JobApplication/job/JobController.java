package com.project.JobApplication.job;

import com.project.JobApplication.job.impl.jobServiceImpl;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class JobController {
    private jobServiceImpl jobService;

    public JobController(jobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity <List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findall());
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable long id){
        Job job=jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED) ;
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable long id){
        Boolean deleted=jobService.deleteJobById(id);
        if (deleted){
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id,@RequestBody Job updatedJob){
        Boolean updated=jobService.updateJob(id,updatedJob);
        if (updated){
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
