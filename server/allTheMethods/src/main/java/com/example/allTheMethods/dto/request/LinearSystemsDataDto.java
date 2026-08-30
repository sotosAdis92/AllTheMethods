package com.example.allTheMethods.dto.request;

import java.util.List;
import java.util.Optional;

public record LinearSystemsDataDto(
        List<Double> inp,
        List<List<Double>> matrix,
        List<Optional<String>> variables,
        List<Optional<Double>> equals
) {
}
