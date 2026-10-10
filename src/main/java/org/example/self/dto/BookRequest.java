package org.example.self.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BookRequest {
    @NotBlank
    private String bookName;
    @NotBlank
    private String bookAuthor;
    @Min(0) private int bookPrice;
    @NotBlank
    private String category;
}
