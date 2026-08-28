package com.example.allTheMethods.dto.request;

import java.util.List;
import java.util.Optional;

public record LinearSystemsDataDto(
        double[][] matrix,
        List<Optional<String>> variables
) {
}
