package com.dharmendra.Job_Search_Portal.service;

import com.dharmendra.Job_Search_Portal.model.JobPortal;
import com.dharmendra.Job_Search_Portal.model.Type;
import com.dharmendra.Job_Search_Portal.repo.JobPortalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class JobPortalService {

@Autowired
    JobPortalRepo Linkedin;

    public String addJobs(List<JobPortal> jobPortal) {

      Linkedin.saveAll(jobPortal);
      return jobPortal.size() + " job uploaded successfully!!1";
    }

    public String updateJobById(Long id, Double salary) {

         Optional<JobPortal> optional = Linkedin.findById(id);

        JobPortal job = optional.orElse(new JobPortal());
        if(job.getId().equals(id)){
            job.setSalary(salary);
            Linkedin.save(job);
            return "information updated";
        }
    return "invalid id";
    }

    public String deleteById(Long id) {

        Linkedin.deleteById(id);
        return id + "  deleted successfully";
    }

    public List<JobPortal> getJobByLocationSalary(Double salary,String location) {

        return Linkedin.findBySalaryGreaterThanEqualAndLocation(salary, location);
    }


    public List<JobPortal> getJobByIdAndType(Long id, Type jobType) {
        return Linkedin.findByIdOrJobType(id,  jobType);
    }
}
