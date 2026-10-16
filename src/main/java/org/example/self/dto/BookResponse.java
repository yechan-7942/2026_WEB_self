package org.example.self.dto;
import org.example.self.domain.Book;
public record BookResponse (
        String title, String author, int price, String ct
){

    public static BookResponse from (Book book){
        return new BookResponse(
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getCt()
        );
    }
}
