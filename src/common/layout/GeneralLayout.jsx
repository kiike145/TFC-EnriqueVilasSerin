import { Grid } from '@mui/material';
import React from 'react';

const GeneralLayout = ({ children }) => {
  return (
    <Grid container>
      <Grid container sx={{ minHeight: '10vh', backgroundColor: 'primary.main' }}>
        a
      </Grid>
      {children}
      <Grid container sx={{ minHeight: '10vh', backgroundColor: 'primary.main' }}>
        a
      </Grid>
    </Grid>
  );
};

export default GeneralLayout;
