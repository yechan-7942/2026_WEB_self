package org.example.exam.dto;

import jakarta.validation.constraints.NotBlank;

public record BookRequest(
        @NotBlank(message = "제목을 입력하세요.") String title,
        @NotBlank(message = "저자를 입력하세요.") String author
) {
}
