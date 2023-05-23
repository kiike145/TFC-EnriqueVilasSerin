import { AppBar, Grid, Toolbar } from '@mui/material';
import React from 'react';

const GeneralLayout = ({ children }) => {
  return (
    <Grid>
      <Grid
        container
        component="header"
        alignItems="center"
        sx={{ minHeight: '10vh', backgroundColor: 'primary.main', pr: '2rem', pl: '2rem' }}
      >
        <Grid
          container
          component="nav"
          justifyContent="space-between"
          sx={{ minWidth: '100%', flexWrap: 'wrap', flexGrow: 0 }}
        >
          <Grid item container xs={6} justifyContent="flex-start">
            Foto&nbsp;
            <a href="/">Home</a> &nbsp;
            <a href="/products">Productos</a> &nbsp;
            <a href="/cart">Carro</a>
          </Grid>
          <Grid item container xs={6} justifyContent="flex-end">
            <a href="/login">Login</a> &nbsp;
            <a href="/signup">Sign up</a>
          </Grid>
        </Grid>
      </Grid>
      <Grid container component="main" direction="column" sx={{ minHeight: '80vh', backgroundColor: '#F9F9F9' }}>
        {children}
      </Grid>
      <Grid
        container
        component="footer"
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
