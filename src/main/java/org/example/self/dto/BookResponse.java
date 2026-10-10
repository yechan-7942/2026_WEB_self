package org.example.self.dto;

import org.example.self.domain.Book;

public record BookResponse(Long id, String title, String author, int price, String category) {

    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getCategory()
        );
    }
}
