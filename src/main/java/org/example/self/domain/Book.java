package org.example.self.domain;

public class Book {

    private String id;
    private String name;
    private int price;
    private String ct;//카테고리

    public Book(){

    }
    public Book(String id ,String name, int price, String ct){
        this.id = id;
        this.name = name;
        this.price = price;
        this.ct = ct;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }
}
