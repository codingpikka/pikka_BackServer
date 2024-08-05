package com.ohgiraffers.codingpikka_admin.notice.controller;

import com.ohgiraffers.codingpikka_admin.notice.model.NoticeDTO;
import com.ohgiraffers.codingpikka_admin.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class NoticeController {
    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("admin/notice")
    public ResponseEntity<List<NoticeDTO>> getAllNotices() {
        return ResponseEntity.ok(noticeService.getAllNotices());
    }

    @GetMapping("admin/notice/{id}")
    public ResponseEntity<NoticeDTO> getNotice(@PathVariable Integer id) {
        return ResponseEntity.ok(noticeService.getNotice(id));
    }

    @PostMapping("admin/notice")
    public ResponseEntity<NoticeDTO> createNotice(@RequestBody NoticeDTO noticeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(noticeService.createNotice(noticeDTO));
    }

    @PutMapping("admin/notice/{id}")
    public ResponseEntity<NoticeDTO> updateNotice(@PathVariable Integer id, @RequestBody NoticeDTO noticeDTO) {
        return ResponseEntity.ok(noticeService.updateNotice(id, noticeDTO));
    }

    @DeleteMapping("admin/notice/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Integer id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}