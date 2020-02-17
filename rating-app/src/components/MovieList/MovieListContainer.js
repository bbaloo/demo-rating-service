import {connect} from 'react-redux'
import MovieList from "./MovieList";
import {getMovieList} from "../../modules/selectors";
import {fetchMovies, rateMovieRequest} from "../../modules/actions";

const mapStateToProps = state => {
    return {
        movieList: getMovieList(state)
    }
};
const mapDispatchToProps = dispatch => {
    return {
        onRateMovie: data => {
            dispatch(rateMovieRequest(data))
        },
        fetchMovies: () => {
            dispatch(fetchMovies())
        }
    }
};
const MovieListContainer = connect(
    mapStateToProps,
    mapDispatchToProps
)(MovieList);

export default MovieListContainer;