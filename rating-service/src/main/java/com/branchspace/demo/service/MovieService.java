package com.branchspace.demo.service;

import com.branchspace.demo.dto.MovieDto;
import com.branchspace.demo.dto.RateDto;
import com.branchspace.demo.dto.VoteDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovies();

    void rateMovie(VoteDto rate);

    List<RateDto> getMovieRates(String movieId);
}
