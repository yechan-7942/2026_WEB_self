package org.example.self.repository;

import org.example.self.domain.Book;

import java.util.List;

public interface BookRepository {
    Book findById(Long id);
    List<Book> findAll();
    Book save(Book book);
    void deleteById(Long id);
    Book update(Book book);
}
