package com.project.spring_boot_rest.repo;

import com.project.spring_boot_rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobPosts = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),

                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),

                new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),

                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))));


    public List<JobPost> getAllJobs() {
        return jobPosts;
    }

    public void addJob(JobPost jobPost) {
        jobPosts.add(jobPost);
    }

    public JobPost getJobPost(int jobId) {
        return jobPosts.stream().filter(x -> x.getPostId() == jobId).findFirst().orElse(null);
    }

    public void updateJob(JobPost jobPost) {
        for (JobPost post : jobPosts) {
            if (post.getPostId() == jobPost.getPostId()) {
                post.setPostId(jobPost.getPostId());
                post.setPostDesc(jobPost.getPostDesc());
                post.setPostProfile(jobPost.getPostProfile());
                post.setReqExperience(jobPost.getReqExperience());
                post.setPostTechStack(jobPost.getPostTechStack());

                break;
            }
        }
    }

    public void deleteJob(int jobId) {
        for (JobPost jobPost : jobPosts) {
            if (jobPost.getPostId() == jobId) {
                jobPosts.remove(jobPost);
                break;
            }
        }
    }
}
