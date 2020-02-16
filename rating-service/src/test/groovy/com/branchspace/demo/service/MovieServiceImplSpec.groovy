package com.branchspace.demo.service

import com.branchspace.demo.dto.VoteDto
import com.branchspace.demo.exception.MovieServiceException
import com.branchspace.demo.factory.MovieDtoFactory
import com.branchspace.demo.model.Movie
import com.branchspace.demo.model.MovieGenre
import com.branchspace.demo.model.Rating
import com.branchspace.demo.repository.MovieRepository
import spock.lang.Specification

import java.util.stream.Collectors
import java.util.stream.Stream

class MovieServiceImplSpec extends Specification {

    def repository = Mock(MovieRepository)
    def movieService = new MovieServiceImpl(repository, new MovieDtoFactory())


    def "should return all movies with calculated rate"() {
        given:
        repository.findAll() >> returnMovieList()
        when:
        def result = movieService.getAllMovies()
        then:
        result.size() == 4
        with(result.get(0)) {
            id == "1"
            title == "Silence of the Lambdas"
            rating == 2
        }
        with(result.get(1)) {
            id == "2"
            rating == 8
        }
        with(result.get(2)) {
            id == "3"
            rating == 0
        }
        with(result.get(3)) {
            id == "4"
            rating == 1
        }

    }

    def "should return single movie rates"() {
        given:
        repository.findById(_ as String) >> Optional.of(returnSingleMovie())
        when:
        def result = movieService.getMovieRates("4")
        then:
        result.size() == 3
    }

    def "should successfully rate movie"() {
        given:
        repository.findById(_ as String) >> Optional.of(returnSingleMovie())
        when:
        movieService.rateMovie(VoteDto.builder()
                .movieId("4")
                .rate(2)
                .build())
        then:
        1 * repository.save(_ as Movie)
    }

    def 'rate not existing movie should cause an exception'() {
        given:
        repository.findById(_ as String) >> Optional.ofNullable(null)
        when:
        movieService.rateMovie(VoteDto.builder()
                .movieId("4")
                .rate(2)
                .build())
        then:
        thrown(MovieServiceException)
    }

    static def returnSingleMovie() {
        Movie.builder()
                .id("1")
                .genre(MovieGenre.ACTION)
                .title("Silence of the Lambdas")
                .productionTimestamp(887478287L)
                .rating([new Rating(1), new Rating(2), new Rating(3)] as List)
                .build()
    }

    static def returnMovieList() {
        Stream.of(
                Movie.builder()
                        .id("1")
                        .genre(MovieGenre.ACTION)
                        .title("Silence of the Lambdas")
                        .productionTimestamp(887478287L)
                        .rating([new Rating(1), new Rating(2), new Rating(3)] as List)
                        .build(),
                Movie.builder()
                        .id("2")
                        .genre(MovieGenre.ACTION)
                        .title("Movie Two")
                        .productionTimestamp(961706051L)
                        .rating([new Rating(10), new Rating(4), new Rating(10)] as List)
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
                        .rating([new Rating(1), new Rating(1), new Rating(1)] as List)
                        .build())
                .collect(Collectors.toList());
    }
}
