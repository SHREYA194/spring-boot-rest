package com.project.spring_boot_rest.service;

import com.project.spring_boot_rest.model.JobPost;
import com.project.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }

    public JobPost getJobPost(int jobId) {
        return jobRepo.getJobPost(jobId);
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.updateJob(jobPost);
    }

    public void deleteJob(int jobId) {
        jobRepo.deleteJob(jobId);
    }
}
