package com.project.spring_boot_rest.controller;

import com.project.spring_boot_rest.model.JobPost;
import com.project.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping(path="jobPost/{id}", produces = "application/xml")
    public JobPost getJobPost(@PathVariable("id") int id) {
        return jobService.getJobPost(id);
    }

    @PostMapping(path="jobPost", consumes = "application/json")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobService.getJobPost(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJobPost(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{jobId}")
    public void deleteJob(@PathVariable int jobId) {
        jobService.deleteJob(jobId);
    }

    @GetMapping("load")
    public String loadData() {
        jobService.loadData();
        return "success";
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword) {
        return jobService.searchByKeyword(keyword);
    }

}
