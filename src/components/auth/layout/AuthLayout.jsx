import { Grid, Typography } from '@mui/material';
import React from 'react';
import GeneralLayout from '../../common/layout/GeneralLayout';
const AuthLayout = ({ children, title = '' }) => {
  return (
    <Grid
      container
      sx={{ minHeight: '100vh', backgroundColor: '#F9F9F9', padding: 4 }}
      spacing={0}
      direction="column"
      justifyContent="center"
      alignItems="center"
    >
      <Grid
        item
        xs={3}
        sx={{
          backgroundColor: 'white',
          padding: 3,
          borderRadius: 2,
          width: { sm: 450 },
          boxShadow: '0px 5px 5px rgba(0, 0, 0, 0.2)',
        }}
        className="box-shadow"
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
