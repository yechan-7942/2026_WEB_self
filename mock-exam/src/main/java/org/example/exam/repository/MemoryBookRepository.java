package org.example.exam.repository;

import org.example.exam.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryBookRepository implements BookRepository {
    private final Map<String, Book> books = new LinkedHashMap<>();

    public MemoryBookRepository() {
        // 화면 확인용 초기 데이터입니다. 저장 기능 구현 전에도 목록이 보여야 합니다.
        books.put("sample-1", new Book("sample-1", "자바 첫걸음", "김자바", false));
        books.put("sample-2", new Book("sample-2", "스프링 입문", "이스프링", true));
    }

    @Override
    public Book save(Book book) {
        // TODO-04: books에 도서를 저장하세요. key는 도서 ID입니다.
        books.put(book.getId(),book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Optional<Book> findById(String id) {
        // TODO-07: ID에 해당하는 도서를 Optional로 반환하세요.
        return Optional.empty(); // 임시 반환값: 구현 후 교체
    }
}
