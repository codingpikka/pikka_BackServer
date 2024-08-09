package com.ohgiraffers.pikka_backserver.curation.service;


import com.ohgiraffers.pikka_backserver.auth.config.APIEntity;
import com.ohgiraffers.pikka_backserver.curation.repository.CurationRepository;
import com.ohgiraffers.pikka_backserver.job.entity.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CurationService {

    @Autowired
    private CurationRepository repository;

    public List<JobEntity> findAll() {
        return repository.findAll();
    }

    public Optional<JobEntity> findById(Integer id) {
        return repository.findById(id);
    }

    public JobEntity save(JobEntity jobEntity) {
        return repository.save(jobEntity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
