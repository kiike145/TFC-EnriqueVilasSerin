import { createTheme } from '@mui/material';
import { grey, red } from '@mui/material/colors';

export const theme = createTheme({
  palette: {
    primary: {
      main: '#FFD54F',
    },
    secondary: {
      main: grey[600],
    },
    error: {
      main: red[400],
    },
  },
});
