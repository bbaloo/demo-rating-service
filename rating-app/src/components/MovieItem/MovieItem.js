import React from 'react';
import PropTypes from 'prop-types'
import {getHumanReadableDate} from "../../modules/utils";
import {MOVIE_GENRE_TO_IMAGE} from "../../images";
import Button from '@material-ui/core/Button';

import './MovieItem.scss';

const setNumberPrecision = num => num ? Math.round((num + Number.EPSILON) * 100) / 100 : "No rating";

const MovieItem = ({movieItem, onRateMovie}) => {

    return (
        <div className="movie-item">
            <div className="movie-item__title">{movieItem.title}</div>
            <div className="movie-item__date">{getHumanReadableDate(movieItem.productionTimestamp)}</div>
            <div className="movie-item__image"><img src={MOVIE_GENRE_TO_IMAGE[movieItem.genre]} alt="img"/></div>
            <div className="movie-item__rate">Rating: {setNumberPrecision(movieItem.rating)}</div>
            <Button variant="contained" color="primary" onClick={() => onRateMovie(movieItem.id)}>Rate movie</Button>
        </div>
    );
};

MovieItem.propTypes = {
    movieItem: PropTypes.shape({
        id: PropTypes.string,
        title: PropTypes.string,
        genre: PropTypes.string,
        productionTimestamp: PropTypes.number,
        rating: PropTypes.number

    }),
    onRateMovie: PropTypes.func
};

export default MovieItem;
