package com.myproj.JobCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.JobCrud.model.JobApplication;
import com.myproj.JobCrud.service.JobApplicationService;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {
   @Autowired
   private JobApplicationService jobApplicationService;

   @PostMapping
   public ResponseEntity<JobApplication> createJobApplication(@RequestBody JobApplication jobApplication) {
      return ResponseEntity.ok(jobApplicationService.createJobApplication(jobApplication));
   }

   @GetMapping("/{userId}")
   public ResponseEntity<List<JobApplication>> getJobApplications(@PathVariable Long userId) {
      return ResponseEntity.ok(jobApplicationService.getJobApplications(userId));
   }
}
