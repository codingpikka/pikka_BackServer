package com.ohgiraffers.condingpikka_user.notice.controller;

import com.ohgiraffers.condingpikka_user.notice.model.NoticeDTO;
import com.ohgiraffers.condingpikka_user.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class NoticeController {
    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("notices")
    public ResponseEntity<List<NoticeDTO>> getAllNotices() {
        return ResponseEntity.ok(noticeService.getAllNotices());
    }

    @GetMapping("notices/{id}")
    public ResponseEntity<NoticeDTO> getNotice(@PathVariable Integer id) {
        return ResponseEntity.ok(noticeService.getNotice(id));
    }
}