import React, {useEffect, useState} from 'react';
import PropTypes from 'prop-types'
import MovieRateModal from "../MovieRateModal";
import MovieItem from "../MovieItem";

import './MovieList.scss';

const MovieList = ({movieList, fetchMovies, onRateMovie}) => {

    useEffect(() => {
        fetchMovies();
    }, [fetchMovies]);

    const [selectedMovieId, setSelectedMovieId] = useState(null);

    const rateMovie = rate => {
        onRateMovie({movieId: selectedMovieId, rate});
        setSelectedMovieId(null);
    };

    return (
        <div className="movie-list">
            <div className="movie-list__items">
                {
                    movieList.map(movie =>
                        <MovieItem key={movie.id} movieItem={movie} onRateMovie={setSelectedMovieId}/>
                    )
                }
            </div>
            {selectedMovieId && (
                <MovieRateModal onClose={() => setSelectedMovieId(null)} onSave={rateMovie}/>
            )}
        </div>
    );
};

MovieList.propTypes = {
    movieList: PropTypes.arrayOf(PropTypes.shape()),
    onRateMovie: PropTypes.func,
    fetchMovies: PropTypes.func
};

export default MovieList;
