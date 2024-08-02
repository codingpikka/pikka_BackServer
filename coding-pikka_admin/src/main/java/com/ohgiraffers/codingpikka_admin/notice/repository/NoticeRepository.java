package com.ohgiraffers.codingpikka_admin.notice.repository;

import com.ohgiraffers.codingpikka_admin.notice.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {
    List<NoticeEntity> findAllByOrderByCreatedAtDesc();
}