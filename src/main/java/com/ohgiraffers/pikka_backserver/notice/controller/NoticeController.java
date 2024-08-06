package com.ohgiraffers.pikka_backserver.notice.controller;

import com.ohgiraffers.pikka_backserver.notice.model.NoticeDTO;
import com.ohgiraffers.pikka_backserver.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    // 일반 사용자 및 관리자용 엔드포인트
    @GetMapping
    public ResponseEntity<List<NoticeDTO>> getAllNotices() {
        return ResponseEntity.ok(noticeService.getAllNotices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticeDTO> getNotice(@PathVariable Integer id) {
        return ResponseEntity.ok(noticeService.getNotice(id));
    }

    // 관리자용 엔드포인트
    @PostMapping
    public ResponseEntity<NoticeDTO> createNotice(@RequestBody NoticeDTO noticeDTO) {
        return ResponseEntity.ok(noticeService.createNotice(noticeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticeDTO> updateNotice(@PathVariable Integer id, @RequestBody NoticeDTO noticeDTO) {
        return ResponseEntity.ok(noticeService.updateNotice(id, noticeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Integer id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.ok().build();
    }
    //테스트용
}