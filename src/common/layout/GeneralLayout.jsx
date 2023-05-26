import { AppBar, Box, Grid, Toolbar } from '@mui/material';
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
          <Box>
            Foto &nbsp;
            <a href="/">Home</a> &nbsp;
            <a href="/products">Productos</a> &nbsp;
            <a href="/cart">Carro</a>
          </Box>

          <Box>
            <a href="/login">Login</a> &nbsp;
            <a href="/signup">Sign up</a>
          </Box>
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
