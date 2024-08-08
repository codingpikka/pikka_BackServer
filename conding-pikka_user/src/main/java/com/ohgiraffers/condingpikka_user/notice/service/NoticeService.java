package com.ohgiraffers.condingpikka_user.notice.service;

import com.ohgiraffers.condingpikka_user.notice.entity.NoticeEntity;
import com.ohgiraffers.condingpikka_user.notice.model.NoticeDTO;
import com.ohgiraffers.condingpikka_user.notice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<NoticeDTO> getAllNotices() {
        return noticeRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public NoticeDTO getNotice(Long id) {
        return noticeRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Notice not found with id: " + id));
    }

    private NoticeDTO convertToDTO(NoticeEntity entity) {
        return new NoticeDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}