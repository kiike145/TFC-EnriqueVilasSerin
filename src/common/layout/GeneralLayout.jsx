import { Grid } from '@mui/material';
import React from 'react';

const GeneralLayout = ({ children }) => {
  return (
    <Grid container>
      <Grid
        container
        alignItems="center"
        justifyContent="space-between"
        sx={{ minHeight: '10vh', backgroundColor: 'primary.main', pr: '2rem', pl: '2rem' }}
      >
        <span>Foto</span>
        <a href="/">Home</a>
        <a href="/products">Productos</a>
        <a href="/cart">Carro</a>

        <a href="/login">Login</a>
        <a href="/signup">Sign up</a>
      </Grid>
      {children}
      <Grid
        container
        alignItems="center"
        justifyContent="center"
        sx={{ minHeight: '10vh', backgroundColor: 'primary.main' }}
      >
        a
      </Grid>
    </Grid>
  );
};

export default GeneralLayout;
