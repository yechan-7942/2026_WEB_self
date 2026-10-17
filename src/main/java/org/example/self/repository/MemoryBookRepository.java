package org.example.self.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.example.self.domain.Book;
@Repository

public class MemoryBookRepository implements BookRepository {
    private final Map<String, Book> books = new HashMap<>();

    @Override
    public Book save(Book book){
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book update(Book book){
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public List<Book>findAll(){
        return new ArrayList<>(books.values());
    }


    @Override
    public void deleteById(String id) {
        books.remove(id);
    }
}
