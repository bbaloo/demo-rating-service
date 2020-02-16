package com.branchspace.demo.configuration;

import com.branchspace.demo.model.Movie;
import com.branchspace.demo.model.MovieGenre;
import com.branchspace.demo.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class DbInitializer {

    private final MovieRepository movieRepository;

    public void initDatabase() {
        movieRepository.saveAll(getInitialData());
    }

    private List<Movie> getInitialData() {
        return Stream.of(
                Movie.builder()
                        .id("1")
                        .genre(MovieGenre.ACTION)
                        .title("Silence of the Lambdas")
                        .productionTimestamp(887478287L)
                        .rating(Collections.EMPTY_LIST)
                        .build(),
                Movie.builder()
                        .id("2")
                        .genre(MovieGenre.ACTION)
                        .title("Movie Two")
                        .productionTimestamp(961706051L)
                        .rating(Collections.EMPTY_LIST)
                        .build(),
                Movie.builder()
                        .id("3")
                        .genre(MovieGenre.COMEDY)
                        .title("Movie Three")
                        .productionTimestamp(1581712499L)
                        .rating(Collections.EMPTY_LIST)
                        .build(),
                Movie.builder()
                        .id("4")
                        .genre(MovieGenre.DRAMA)
                        .title("Movie Four")
                        .productionTimestamp(1151008451L)
                        .rating(Collections.EMPTY_LIST)
                        .build(),
                Movie.builder()
                        .id("5")
                        .genre(MovieGenre.COMEDY)
                        .title("Movie Five")
                        .productionTimestamp(1119472451L)
                        .rating(Collections.EMPTY_LIST)
                        .build(),
                Movie.builder()
                        .id("6")
                        .genre(MovieGenre.FANTASY)
                        .title("Movie Six")
                        .productionTimestamp(1116794051L)
                        .rating(Collections.EMPTY_LIST)
                        .build(),
                Movie.builder()
                        .id("7")
                        .genre(MovieGenre.FANTASY)
                        .title("Movie Seven")
                        .productionTimestamp(1085258051L)
                        .rating(Collections.EMPTY_LIST)
                        .build(),
                Movie.builder()
                        .id("8")
                        .genre(MovieGenre.CRIME)
                        .title("Movie Eight")
                        .productionTimestamp(1053635651L)
                        .rating(Collections.EMPTY_LIST)
                        .build())
                .collect(Collectors.toList());
    }

}
