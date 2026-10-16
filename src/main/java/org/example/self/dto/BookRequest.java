package org.example.self.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record BookRequest(
        @NotBlank String title,
        @NotBlank String author,
        @PositiveOrZero int price,
        @NotBlank String ct
) {
}
