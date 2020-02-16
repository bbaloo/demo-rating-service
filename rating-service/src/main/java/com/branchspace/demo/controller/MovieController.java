package com.branchspace.demo.controller;

import com.branchspace.demo.dto.MovieDto;
import com.branchspace.demo.dto.RateDto;
import com.branchspace.demo.dto.VoteDto;
import com.branchspace.demo.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin //only for demo
@RestController
@AllArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "/movies")
    public List<MovieDto> getAllMovies() {
        log.info("Request for get all movies data.");
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/movie/{movieId}/rates")
    public List<RateDto> getMovieRates(@PathVariable String movieId) {
        return movieService.getMovieRates(movieId);
    }

    @PostMapping(value = "movie/rate")
    public void rateMovie(@RequestBody @Valid VoteDto voteDto) {
        log.info("Add new movie rate {} request", voteDto);
        movieService.rateMovie(voteDto);
    }
}
