package com.branchspace.demo.service;

import com.branchspace.demo.dto.MovieDto;
import com.branchspace.demo.dto.RateDto;
import com.branchspace.demo.dto.VoteDto;
import com.branchspace.demo.exception.MovieServiceException;
import com.branchspace.demo.factory.MovieDtoFactory;
import com.branchspace.demo.model.Movie;
import com.branchspace.demo.model.Rating;
import com.branchspace.demo.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieDtoFactory movieDtoFactory;

    @Override
    @Synchronized
    public List<MovieDto> getAllMovies() {
        final List<Movie> movieList = movieRepository.findAll();
        return movieList.stream()
                .map(movieDtoFactory::createMovieDto)
                .collect(Collectors.toList());
    }

    @Override
    @Synchronized
    public void rateMovie(VoteDto rate) {
        final Optional<Movie> movieToRate = movieRepository.findById(rate.getMovieId());
        if (movieToRate.isPresent()) {
            final Movie movie = movieToRate.get();
            addMovieRate(movie, rate.getRate());
            movieRepository.save(movie);
        } else {
            throw new MovieServiceException("Movie not found.");
        }
    }

    private void addMovieRate(Movie movie, Integer rate) {
        movie.getRating().add(new Rating(rate));
    }

    @Override
    public List<RateDto> getMovieRates(String movieId) {
        final Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            return movie.get().getRating().stream().map(RateDto::from).collect(Collectors.toList());
        } else {
            throw new MovieServiceException("Movie not found.");
        }
    }
}
