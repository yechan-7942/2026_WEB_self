package org.example.exam.repository;

import org.example.exam.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
    Optional<Book> findById(String id);
}
