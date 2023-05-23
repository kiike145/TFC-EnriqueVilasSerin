import React from 'react';
import { Grid, Typography } from '@mui/material';
import GeneralLayout from '../../../../common/layout/GeneralLayout';

export const HomePage = () => {
  return (
    <GeneralLayout>
      <Typography variant="h1">Hola!</Typography>
      <Grid container direction="row" wrap="wrap">
        <Grid container sx={{ maxWidth: '50%' }}>
          banner
        </Grid>
        <Grid container sx={{ maxWidth: '50%' }} justifyContent="center">
          <h3>Artículos destacados</h3>
        </Grid>
      </Grid>
    </GeneralLayout>
  );
};
