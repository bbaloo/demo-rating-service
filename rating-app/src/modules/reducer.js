import {Map} from "immutable";
import { FETCH_MOVIES_SUCCESS} from './constants';

const initialState = Map({movieList: []});

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_MOVIES_SUCCESS:
            return state.set('movieList', action.payload);
        default:
            return state;
    }
};

export default reducer;
