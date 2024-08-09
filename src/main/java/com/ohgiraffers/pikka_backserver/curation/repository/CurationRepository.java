package com.ohgiraffers.pikka_backserver.curation.repository;


import com.ohgiraffers.pikka_backserver.auth.config.APIEntity;
import com.ohgiraffers.pikka_backserver.job.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurationRepository extends JpaRepository<JobEntity, Integer> {


}
