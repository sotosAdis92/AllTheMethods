package com.example.allTheMethods.dto.response;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        String message,
        LocalDateTime time
) {
}
