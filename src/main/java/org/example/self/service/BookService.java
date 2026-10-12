package org.example.self.service;

import java.util.List;

import org.example.self.domain.Book;
import org.example.self.dto.BookRequest;
import org.example.self.dto.BookResponse;
import org.example.self.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getTitle().contains(title))
                .toList();
    }

    public BookResponse updateBook(Long id, BookRequest request) {
        Book book = findBook(id);
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setPrice(request.price());
        book.setCategory(request.category());

        return BookResponse.from(bookRepository.update(book));
    }

    private Book findBook(Long id) {
        Book book = bookRepository.findById(id);
        if (book == null) {
            throw new IllegalArgumentException("책을 찾을 수 없습니다. id=" + id);
        }
        return book;
    }

    public void delete(Long id) {
        findBook(id);
        bookRepository.deleteById(id);
    }


}
