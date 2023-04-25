import { createTheme } from '@mui/material';
import { red } from '@mui/material/colors';

export const theme = createTheme({
  palette: {
    primary: {
      main: '#FFD54F',
    },
    secondary: {
      main: '#8E0EAB',
    },
    error: {
      main: red[400],
    },
  },
});
