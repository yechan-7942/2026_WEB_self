package org.example.self.domain;

public class Book {

    private String id;
    private String title;
    private String author;
    private int price;
    private String ct;//카테고리


    public Book(){

    }
    public Book(String id ,String title, String author, int price, String ct){
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.ct = ct;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public String getCt() {
        return ct;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }
}
