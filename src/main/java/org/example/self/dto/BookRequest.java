package org.example.self.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record BookRequest(
        @NotBlank(message = "책 이름을 입력하세요") String title,
        @NotBlank(message = "저자를 입력하세요") String author,
        @Min(value = 0, message = "가격은 0 이상이어야 합니다") int price,
        @NotBlank(message = "카테고리를 입력하세요") String category
) {
}
