package com.myproj.JobCrud.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproj.JobCrud.model.StatusChangeHistory;

@Repository
public interface StatusChangeHistoryRepository extends JpaRepository<StatusChangeHistory, Long> {
   List<StatusChangeHistory> findByJobApplicationId(Long jobApplicationId);
}