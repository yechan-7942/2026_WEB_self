package org.example.exam.service;

import org.example.exam.domain.Book;
import org.example.exam.dto.BookRequest;
import org.example.exam.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void create(BookRequest request) {
        // TODO-03: UUID.randomUUID().toString()으로 ID를 만들고,
        // 제목/저자는 trim(), 읽음 상태는 false로 도서를 생성해 저장하세요.
    }

    public List<Book> findAll(String status) {
        // TODO-10: all(전체), read(읽음), unread(안 읽음)에 맞춰 필터링하세요.
        // 알 수 없는 값은 전체 목록으로 처리하세요.
        return repository.findAll(); // 임시: 필터 없이 전체 반환
    }

    public void toggleRead(String id) {
        // TODO-08: repository.findById(id)로 도서를 찾고 상태를 변경하세요.
        // 없는 ID는 ResponseStatusException(HttpStatus.NOT_FOUND, "도서 없음") 처리.
        // 상태 변경 후 repository.save(book)을 호출하세요.
    }

    public long totalCount() {
        return repository.findAll().size();
    }

    public long readCount() {
        // TODO-11: 전체 도서 중 읽음 상태인 도서 수를 반환하세요.
        return 0; // 임시 반환값: 구현 후 교체
    }
}
