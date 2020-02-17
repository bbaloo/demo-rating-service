import React from 'react';
import {Provider} from "react-redux";
import {store} from "./modules/store";
import MovieList from "./components/MovieList";

function App() {
    return (
        <Provider store={store}>
        <div className="App">
            <MovieList/>
        </div>
        </Provider>
    );
}

export default App;
