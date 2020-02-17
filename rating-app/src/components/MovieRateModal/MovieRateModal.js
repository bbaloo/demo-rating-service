import React, {useState} from 'react';
import PropTypes from 'prop-types'
import {Slider} from '@material-ui/core';
import Button from '@material-ui/core/Button';

import './MovieRateModal.scss';

const MovieRateModal = ({onSave, onClose}) => {

    const [value, setValue] = useState(1);
    const handleChange = (event, value) => setValue(value);

    return (
        <div className="modal">
            <div className="movie-rate-modal">
                <div className="movie-rate-modal__header">
                    <h2>Rate movie</h2>
                </div>
                <div className="movie-rate-modal__body">
                    <Slider
                        value={value}
                        min={1}
                        step={1}
                        max={10}
                        onChange={handleChange}
                        valueLabelDisplay="on"
                        aria-labelledby="non-linear-slider"
                    />
                </div>
                <div className="movie-rate-modal__footer">
                    <Button variant="contained" onClick={onClose}>Cancel</Button>
                    <Button variant="contained" color="primary" onClick={() => onSave(value)}>Save</Button>
                </div>

            </div>
        </div>
    );
};

MovieRateModal.propTypes = {
    onSave: PropTypes.func,
    onClose: PropTypes.func
};

export default MovieRateModal;
