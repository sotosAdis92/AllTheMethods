package com.example.allTheMethods.dto.request;

import java.util.List;

public record LinearSystemsDataDto(
        int[][] matrix,
        List<String> variables
) {
}
