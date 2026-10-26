package com.example.allTheMethods.dto.response;

import java.time.LocalDateTime;

public record ErrorResponse(
        String message,
        LocalDateTime time
) {
}
