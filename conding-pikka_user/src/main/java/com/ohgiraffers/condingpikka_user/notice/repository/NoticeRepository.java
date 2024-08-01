package com.ohgiraffers.condingpikka_user.notice.repository;

import com.ohgiraffers.condingpikka_user.notice.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    List<NoticeEntity> findAllByOrderByCreatedAtDesc();
}