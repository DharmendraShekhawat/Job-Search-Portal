package com.dharmendra.Job_Search_Portal.repo;

import com.dharmendra.Job_Search_Portal.model.JobPortal;
import com.dharmendra.Job_Search_Portal.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPortalRepo extends CrudRepository<JobPortal, Long> {


    List<JobPortal> findBySalaryGreaterThanEqualAndLocation(Double salary, String location);

    List<JobPortal> findByIdOrJobType(Long id, Type jobType);
}
