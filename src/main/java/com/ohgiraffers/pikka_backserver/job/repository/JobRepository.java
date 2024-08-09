package com.ohgiraffers.pikka_backserver.job.repository;


import com.ohgiraffers.pikka_backserver.job.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {


}
