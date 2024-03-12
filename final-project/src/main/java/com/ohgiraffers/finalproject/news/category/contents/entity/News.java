package com.ohgiraffers.finalproject.news.category.contents.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_news")
public class News {

    @Id
    @Column(name = "news_code")
    @GeneratedValue
    private Integer code;

    @Column(name = "title")
    private String title;

    @Column(name = "category_name")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "url_to_image")
    private String image;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "ai_description")
    private String ai_description; // 2024-03-12 ai컬럼 추가

    public News() {
    }

    public News(Integer code, String title, String category, String description, String url, String image, LocalDate date, String ai_description) {
        this.code = code;
        this.title = title;
        this.category = category;
        this.description = description;
        this.url = url;
        this.image = image;
        this.date = date;
        this.ai_description = ai_description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAi_description() {
        return ai_description;
    }

    public void setAi_description(String ai_description) {
        this.ai_description = ai_description;
    }

    @Override
    public String toString() {
        return "News{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", date=" + date +
                ", ai_description='" + ai_description + '\'' +
                '}';
    }
}