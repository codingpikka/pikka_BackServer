package com.ohgiraffers.pikka_backserver.notice.model;

import java.time.LocalDateTime;

public class NoticeDTO {

    private Integer notiId;
    private Integer adminId;
    private String adminName;
    private String notiTitle;
    private String notiContents;
    private LocalDateTime notiCreateAt;
    private LocalDateTime notiStartDate;
    private LocalDateTime notiCloseDate;
    private LocalDateTime notiModiDate;

    public NoticeDTO() {}

    public NoticeDTO(Integer notiId, Integer adminId, String adminName, String notiTitle, String notiContents,
                     LocalDateTime notiCreateAt, LocalDateTime notiStartDate, LocalDateTime notiCloseDate,
                     LocalDateTime notiModiDate) {
        this.notiId = notiId;
        this.adminId = adminId;
        this.adminName = adminName;
        this.notiTitle = notiTitle;
        this.notiContents = notiContents;
        this.notiCreateAt = notiCreateAt;
        this.notiStartDate = notiStartDate;
        this.notiCloseDate = notiCloseDate;
        this.notiModiDate = notiModiDate;
    }

    public Integer getNotiId() {
        return notiId;
    }

    public void setNotiId(Integer notiId) {
        this.notiId = notiId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getNotiTitle() {
        return notiTitle;
    }

    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle;
    }

    public String getNotiContents() {
        return notiContents;
    }

    public void setNotiContents(String notiContents) {
        this.notiContents = notiContents;
    }

    public LocalDateTime getNotiCreateAt() {
        return notiCreateAt;
    }

    public void setNotiCreateAt(LocalDateTime notiCreateAt) {
        this.notiCreateAt = notiCreateAt;
    }

    public LocalDateTime getNotiStartDate() {
        return notiStartDate;
    }

    public void setNotiStartDate(LocalDateTime notiStartDate) {
        this.notiStartDate = notiStartDate;
    }

    public LocalDateTime getNotiCloseDate() {
        return notiCloseDate;
    }

    public void setNotiCloseDate(LocalDateTime notiCloseDate) {
        this.notiCloseDate = notiCloseDate;
    }

    public LocalDateTime getNotiModiDate() {
        return notiModiDate;
    }

    public void setNotiModiDate(LocalDateTime notiModiDate) {
        this.notiModiDate = notiModiDate;
    }
}