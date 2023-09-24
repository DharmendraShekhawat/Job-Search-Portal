package com.dharmendra.Job_Search_Portal.controller;

import com.dharmendra.Job_Search_Portal.model.JobPortal;
import com.dharmendra.Job_Search_Portal.model.Type;
import com.dharmendra.Job_Search_Portal.service.JobPortalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class JobPortalController {

@Autowired
    JobPortalService jobPortalService;

@PostMapping("jobs")
public String addJobs(@Valid @RequestBody  List<JobPortal> jobPortal){

    return jobPortalService.addJobs(jobPortal);
}
@PutMapping("job/id")
public String updateJobById(@Valid @RequestParam Long id,@Valid @RequestParam Double salary){

    return jobPortalService.updateJobById(id, salary);
}
@DeleteMapping("job/id/{id}")
public String deleteById(  @RequestParam Long id){

    return jobPortalService.deleteById(id);
}
@GetMapping("jobs")
public List<JobPortal> getJobByLocationSalary( @RequestParam  Double salary, @RequestParam String location){

  return jobPortalService.getJobByLocationSalary(salary, location);
}
@GetMapping("job/id/{id}/type/{type}")
public List<JobPortal> getJobByIdAndType(@PathVariable Long id, @PathVariable Type type){

    return jobPortalService.getJobByIdAndType(id, type);
}
}
