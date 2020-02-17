import {call, put, takeLatest} from 'redux-saga/effects'
import {getMovieList, sendMovieRate} from "./api";
import {fetchMovies, fetchMoviesSuccess, rateMovieRequest} from "./actions";

function* fetchMovieList() {
    try {
        const {data} = yield call(getMovieList);
        yield put(fetchMoviesSuccess(data));
    } catch (e) {
        console.error(e);
    }
}

function* rateMovie({payload}) {
    try {
        yield call(sendMovieRate, payload);
        yield call(fetchMovieList);
    } catch (e) {
        console.error(e);
    }
}

function* appSaga() {
    yield takeLatest(fetchMovies, fetchMovieList);
    yield takeLatest(rateMovieRequest, rateMovie);
}

export default appSaga;