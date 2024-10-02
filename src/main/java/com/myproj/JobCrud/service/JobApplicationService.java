package com.myproj.JobCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproj.JobCrud.model.JobApplication;
import com.myproj.JobCrud.repository.JobApplicationRepository;

@Service
public class JobApplicationService {
   @Autowired
   private JobApplicationRepository jobApplicationRepository;

   public JobApplication createJobApplication(JobApplication jobApplication) {
      return jobApplicationRepository.save(jobApplication);
   }

   public List<JobApplication> getJobApplications(Long userId) {
      return jobApplicationRepository.findByUserId(userId);
   }

   public void deleteJobApplication(Long id) {
      jobApplicationRepository.deleteById(id);
   }

   public JobApplication updateJobApplicationStatus(Long id, String status) {
      JobApplication application = jobApplicationRepository.findById(id).orElseThrow();
      application.setStatus(status);
      return jobApplicationRepository.save(application);
   }
}
