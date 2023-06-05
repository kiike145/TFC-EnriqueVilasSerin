import { Box, Grid } from '@mui/material';
import React from 'react';
import Logout from '../../components/auth/pages/logout/Logout';

import logo from '../../assert/logo.png';

const GeneralLayout = ({ children }) => {
  const isLogged = sessionStorage.getItem('isLogged');

  return (
    <Grid>
      <Grid container component="header" sx={{ minHeight: '12vh', backgroundColor: 'primary.main', pr: '3rem', pl: '3rem' }}>
        <Grid container component="nav" alignItems="center" justifyContent="space-between" sx={{ flexWrap: 'wrap', flexGrow: 0 }}>
          <Grid container direction="row" alignItems="center" justifyContent="space-between" sx={{ flexWrap: 'wrap', width: '15%' }}>
            <a href="/">
              <img src={logo} alt="logo" className="logo" />
            </a>
            <Box>
              <a href="/products">Productos</a> &nbsp;
              <a href="/cart">Carro</a>
            </Box>
          </Grid>

          {isLogged === 'true' ? (
            <Logout />
          ) : (
            <Box>
              <a href="/login">Login</a> &nbsp;
              <a href="/signup">Sign up</a>
            </Box>
          )}
        </Grid>
      </Grid>
      <Grid container component="main" direction="row" sx={{ height: '80vh', backgroundColor: '#F9F9F9' }}>
        {children}
      </Grid>
      <Grid component="footer" alignItems="center" justifyContent="center" sx={{ height: '8vh', backgroundColor: 'primary.main' }}>
        <Box>Proyecto desarrollado por Enrique Vilas Serín</Box>
      </Grid>
    </Grid>
  );
};

export default GeneralLayout;
