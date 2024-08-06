package com.ohgiraffers.pikka_backserver.notice.service;

import com.ohgiraffers.pikka_backserver.notice.entity.NoticeEntity;
import com.ohgiraffers.pikka_backserver.notice.model.NoticeDTO;
import com.ohgiraffers.pikka_backserver.notice.repository.NoticeRepository;
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

    public NoticeDTO getNotice(Integer id) {
        return noticeRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Notice not found with id: " + id));
    }

    public NoticeDTO createNotice(NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = convertToEntity(noticeDTO);
        noticeEntity.setCreatedAt(LocalDateTime.now());
        NoticeEntity savedEntity = noticeRepository.save(noticeEntity);
        return convertToDTO(savedEntity);
    }

    public NoticeDTO updateNotice(Integer id, NoticeDTO noticeDTO) {
        NoticeEntity existingNotice = noticeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Notice not found with id: " + id));

        existingNotice.setTitle(noticeDTO.getTitle());
        existingNotice.setContent(noticeDTO.getContent());
        existingNotice.setUpdatedAt(LocalDateTime.now());

        NoticeEntity updatedEntity = noticeRepository.save(existingNotice);
        return convertToDTO(updatedEntity);
    }

    public void deleteNotice(Integer id) {
        if (!noticeRepository.existsById(id)) {
            throw new NoSuchElementException("Notice not found with id: " + id);
        }
        noticeRepository.deleteById(id);
    }

    private NoticeDTO convertToDTO(NoticeEntity noticeEntity) {
        return new NoticeDTO(
                noticeEntity.getNoticeId(),
                noticeEntity.getTitle(),
                noticeEntity.getContent(),
                noticeEntity.getCreatedAt(),
                noticeEntity.getUpdatedAt()
        );
    }

    private NoticeEntity convertToEntity(NoticeDTO noticeDTO) {
        NoticeEntity entity = new NoticeEntity();
        entity.setTitle(noticeDTO.getTitle());
        entity.setContent(noticeDTO.getContent());
        return entity;
    }
}