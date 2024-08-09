package com.ohgiraffers.pikka_backserver.job.service;

import com.ohgiraffers.pikka_backserver.job.entity.JobEntity;
import com.ohgiraffers.pikka_backserver.job.model.JobDTO;
import com.ohgiraffers.pikka_backserver.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;


    public void saveJob(JobDTO jobDTO) {
        JobEntity jobEntity = new JobEntity();

        jobEntity.setJobCompanyName(jobDTO.getJobCompanyName());
        jobEntity.setJobInfoTitle(jobDTO.getJobInfoTitle());
        jobEntity.setJobWageType(jobDTO.getJobWageType());
        jobEntity.setJobSalary(jobDTO.getJobSalary());
        jobEntity.setJobLocation(jobDTO.getJobLocation());
        jobEntity.setJobEmploymentType(jobDTO.getJobEmploymentType());
//        jobEntity.setJobPostedDate(jobDTO.getJobPostedDate());
//        jobEntity.setJobClosingDate(jobDTO.getJobClosingDate());
        jobEntity.setJobWebInfoUrl(jobDTO.getJobWebInfoUrl());
        jobEntity.setJobMobileInfoUrl(jobDTO.getJobMobileInfoUrl());

        jobRepository.save(jobEntity);


    }
}
