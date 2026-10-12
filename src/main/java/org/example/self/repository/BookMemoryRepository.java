package org.example.self.repository;

import org.example.self.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookMemoryRepository implements BookRepository {

    private final Map<Long, Book> books = new LinkedHashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Book save(Book book) {
        book.setId(counter.incrementAndGet());
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public List<Book> findAll(){
        return new ArrayList<>(books.values());
    }

    @Override
    public Book findById(Long id) {
        return books.get(id);
    }

    @Override
    public void deleteById(Long id) {
        books.remove(id);
    }

    @Override
    public Book update(Book book) {
        books.put(book.getId(), book);
        return book;
    }

}
