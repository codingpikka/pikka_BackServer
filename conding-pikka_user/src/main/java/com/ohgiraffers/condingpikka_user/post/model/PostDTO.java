package com.ohgiraffers.condingpikka_user.post.model;

import org.springframework.web.multipart.MultipartFile;

public class PostDTO {

    private String title;
    private MultipartFile imageFile;
    private String description;
    private String content;

    public PostDTO() {
    }

    public PostDTO(String title, MultipartFile imageFile, String description, String content) {
        this.title = title;
        this.imageFile = imageFile;
        this.description = description;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "title='" + title + '\'' +
                ", imageFile=" + imageFile +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
