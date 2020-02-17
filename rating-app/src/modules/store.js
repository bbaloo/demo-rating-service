import createSagaMiddleware from "redux-saga";
import {applyMiddleware, createStore} from "redux";
import reducer from "./reducer";
import appSaga from "./sagas";

const sagaMiddleware = createSagaMiddleware();

export const store = createStore(
    reducer,
    applyMiddleware(sagaMiddleware)
);

sagaMiddleware.run(appSaga);