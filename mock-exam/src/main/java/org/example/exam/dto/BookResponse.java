package org.example.exam.dto;
import org.example.exam.domain.*;
import java.sql.Struct;

public record BookResponse(String id, String title, String author,boolean read){

    public static BookResponse from(Book book){
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.isRead()
        );
    }
}