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
        return noticeRepository.findAllByOrderByNotiCreateAtDesc().stream()
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
        noticeEntity.setNotiCreateAt(LocalDateTime.now());
        NoticeEntity savedEntity = noticeRepository.save(noticeEntity);
        return convertToDTO(savedEntity);
    }

    public NoticeDTO updateNotice(Integer id, NoticeDTO noticeDTO) {
        NoticeEntity existingNotice = noticeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Notice not found with id: " + id));

        updateEntityFromDTO(existingNotice, noticeDTO);
        existingNotice.setNotiModiDate(LocalDateTime.now());

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
                noticeEntity.getNotiId(),
                noticeEntity.getAdminId(),
                noticeEntity.getAdminName(),
                noticeEntity.getNotiTitle(),
                noticeEntity.getNotiContents(),
                noticeEntity.getNotiCreateAt(),
                noticeEntity.getNotiStartDate(),
                noticeEntity.getNotiCloseDate(),
                noticeEntity.getNotiModiDate()
        );
    }

    private NoticeEntity convertToEntity(NoticeDTO noticeDTO) {
        NoticeEntity entity = new NoticeEntity();
        updateEntityFromDTO(entity, noticeDTO);
        return entity;
    }

    private void updateEntityFromDTO(NoticeEntity entity, NoticeDTO dto) {
        entity.setAdminId(dto.getAdminId());
        entity.setAdminName(dto.getAdminName());
        entity.setNotiTitle(dto.getNotiTitle());
        entity.setNotiContents(dto.getNotiContents());
        entity.setNotiStartDate(dto.getNotiStartDate());
        entity.setNotiCloseDate(dto.getNotiCloseDate());
        // notiCreateAt과 notiModiDate는 서비스 로직에서 설정하므로 여기서는 설정하지 않습니다.
    }
}