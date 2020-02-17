import axios from 'axios';

const API_ENDPOINT = 'http://localhost:8080';

export const getMovieList = () => {
    return axios.get(`${API_ENDPOINT}/movies`);
};

export const sendMovieRate = (payload) => {
    return axios.post(`${API_ENDPOINT}/movie/rate`, payload);
};