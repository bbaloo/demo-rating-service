package com.branchspace.demo.factory;

import com.branchspace.demo.dto.MovieDto;
import com.branchspace.demo.model.Movie;
import com.branchspace.demo.model.Rating;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieDtoFactory {

    public MovieDto createMovieDto(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .productionTimestamp(movie.getProductionTimestamp())
                .rating(calculateAverageRate(movie.getRating()))
                .build();
    }

    private double calculateAverageRate(List<Rating> ratings) {
        return ratings.stream().mapToDouble(Rating::getRate).average().orElse(0.0);
    }
}
