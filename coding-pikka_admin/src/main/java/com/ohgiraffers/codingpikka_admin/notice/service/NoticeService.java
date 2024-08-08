package com.ohgiraffers.codingpikka_admin.notice.service;

import com.ohgiraffers.codingpikka_admin.notice.entity.NoticeEntity;
import com.ohgiraffers.codingpikka_admin.notice.model.NoticeDTO;
import com.ohgiraffers.codingpikka_admin.notice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public NoticeDTO getNotice(Long notice_id) {
        return noticeRepository.findById(notice_id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Notice not found"));
    }

    public NoticeDTO createNotice(NoticeDTO noticeDTO) {
        NoticeEntity entity = convertToEntity(noticeDTO);
        entity.setCreatedAt(LocalDateTime.now());
        return convertToDTO(noticeRepository.save(entity));
    }

    public NoticeDTO updateNotice(Long notice_id, NoticeDTO noticeDTO) {
        return noticeRepository.findById(notice_id)
                .map(entity -> {
                    entity.setTitle(noticeDTO.getTitle());
                    entity.setContent(noticeDTO.getContent());
                    entity.setUpdatedAt(LocalDateTime.now());
                    return convertToDTO(noticeRepository.save(entity));
                })
                .orElseThrow(() -> new NoSuchElementException("Notice not found with id: " + notice_id));
    }

    public void deleteNotice(Long notice_id) {
        noticeRepository.deleteById(notice_id);
    }

    private NoticeDTO convertToDTO(NoticeEntity entity) {
        return new NoticeDTO(
                entity.getNotice_id(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private NoticeEntity convertToEntity(NoticeDTO dto) {
        return new NoticeEntity(
                dto.getNotice_id(),
                dto.getTitle(),
                dto.getContent(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
