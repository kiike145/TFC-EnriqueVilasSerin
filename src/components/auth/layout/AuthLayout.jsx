import { Grid, Typography } from '@mui/material';
import React from 'react';
// import GeneralLayout from '../../common/layout/GeneralLayout';

const AuthLayout = ({ children, title = '' }) => {
  return (
    <Grid
      container
      alignItems="center"
      justifyContent="center"
      direction="column"
      spacing={0}
      sx={{ minHeight: '100vh', backgroundColor: '#F9F9F9', padding: 4 }}
    >
      <Grid
        item
        xs={3}
        className="box-shadow"
        sx={{
          backgroundColor: 'white',
          padding: 3,
          borderRadius: 2,
          width: { sm: 450 },
          boxShadow: '0px 5px 5px rgba(0, 0, 0, 0.2)',
        }}
      >
        <Typography variant="h5" sx={{ mb: 1 }}>
          {title}
        </Typography>
        {children}
      </Grid>
    </Grid>
  );
};

export default AuthLayout;
