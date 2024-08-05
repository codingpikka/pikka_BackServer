package com.ohgiraffers.codingpikka_admin.questions.repository;

import com.ohgiraffers.codingpikka_admin.questions.entity.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<QuestionsEntity, Long> {
}