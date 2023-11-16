package com.example.demo10.modal;

public class Bike {
    private String img ;
    private String content;
    private String title;
    private String author;

    public Bike(String img, String content, String title, String author) {
        this.img = img;
        this.content = content;
        this.title = title;
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
