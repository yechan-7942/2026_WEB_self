package org.example.self.domain;

public class Book {
    private Long id;
    private String title;
    private String author;
    private int price;
    private String category;

    public Long getId() {
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

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
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

    public void setCategory(String category) {
        this.category = category;
    }

    public Book() {
    }
    public Book(Long id, String title, String author, int price, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;

    }
}
