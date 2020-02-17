import {createAction} from 'redux-actions';
import {FETCH_MOVIES, FETCH_MOVIES_SUCCESS, RATE_MOVIE_REQUEST} from "./constants";

//todo: add actions for request/success/fail or use react-routines
export const fetchMovies = createAction(FETCH_MOVIES);
export const fetchMoviesSuccess = createAction(FETCH_MOVIES_SUCCESS);
export const rateMovieRequest = createAction(RATE_MOVIE_REQUEST);