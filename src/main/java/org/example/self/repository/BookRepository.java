package org.example.self.repository;

import  org.example.self.domain.Book;

import  java.util.*;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
    Book update(Book book);
    void deleteById(String id);
}
