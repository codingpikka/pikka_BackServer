package com.ohgiraffers.pikka_backserver.notice.service;


import com.ohgiraffers.pikka_backserver.notice.entity.NoticeEntity;
import com.ohgiraffers.pikka_backserver.notice.model.NoticeDTO;
import com.ohgiraffers.pikka_backserver.notice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class NoticeService {

    private NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<NoticeDTO> getAllNotice(){
        return noticeRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public NoticeDTO getNotice(Integer id){
        return noticeRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Notice not found with id : " + id));
    }

    public NoticeDTO convertToDTO(NoticeEntity noticeEntity){
        return new NoticeDTO(
                noticeEntity.getId(),
                noticeEntity.getTitle(),
                noticeEntity.getContent(),
                noticeEntity.getCreatedAt(),
                noticeEntity.getUpdatedAt()
        );
    }
}
