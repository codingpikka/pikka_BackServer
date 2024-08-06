package com.ohgiraffers.pikka_backserver.notice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_notification")
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noti_id")
    private Integer notiId;

    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "noti_title", nullable = false)
    private String notiTitle;

    @Column(name = "noti_contents", nullable = false, length = 1000)
    private String notiContents;

    @Column(name = "noti_createat", nullable = false)
    private LocalDateTime notiCreateAt;

    @Column(name = "noti_start_date")
    private LocalDateTime notiStartDate;

    @Column(name = "noti_close_date")
    private LocalDateTime notiCloseDate;

    @Column(name = "noti_modi_date")
    private LocalDateTime notiModiDate;

    public NoticeEntity() {}

    public NoticeEntity(Integer notiId, Integer adminId, String adminName, String notiTitle, String notiContents,
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