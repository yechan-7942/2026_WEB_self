package org.example.exam.domain;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private boolean read;

    public Book(String id, String title, String author, boolean read) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.read = read;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isRead() { return read; }

    public void toggleRead() {
        // TODO-06: 현재 읽음 상태를 반대로 변경하세요.
    }
}
