package com.branchspace.demo.dto;

import com.branchspace.demo.model.MovieGenre;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MovieDto {
    String id;
    String title;
    MovieGenre genre;
    Long productionTimestamp;
    Double rating;
}
