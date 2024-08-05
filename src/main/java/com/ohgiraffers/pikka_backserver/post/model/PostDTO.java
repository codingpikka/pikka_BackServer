package com.ohgiraffers.pikka_backserver.post.model;

public class PostDTO {


    private Integer Id;
    private String title;
    private String imageFile;
    private String description;
    private String content;

    public PostDTO() {
    }

    public PostDTO(Integer id, String title, String imageFile, String description, String content) {
        Id = id;
        this.title = title;
        this.imageFile = imageFile;
        this.description = description;
        this.content = content;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
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
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", imageFile='" + imageFile + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
