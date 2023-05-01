import React from 'react';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';

const DateFormPicker = () => {
  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <DatePicker
        sx={{
          minWidth: '100%',
          '.&.Mui-focused .MuiInputLabel-root': {
            borderColor: 'secondary',
          },
          '& .MuiOutlinedInput-notchedOutline.Mui-focused': {
            borderColor: 'secondary',
          },
        }}
        label="Fecha nacimiento"
      />
    </LocalizationProvider>
  );
};

export default DateFormPicker;
