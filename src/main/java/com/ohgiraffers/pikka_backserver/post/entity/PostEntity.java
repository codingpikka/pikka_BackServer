package com.ohgiraffers.pikka_backserver.post.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_imageFile")
    private String imageName;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;


    public PostEntity() {
    }

    public PostEntity(Integer id, String title, String imageName, String description, String content) {
        this.id = id;
        this.title = title;
        this.imageName = imageName;
        this.description = description;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageName='" + imageName + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
