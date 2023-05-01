import { Grid, Typography } from '@mui/material';
import React from 'react';
import GeneralLayout from '../../../common/layout/GeneralLayout';

const AuthLayout = ({ children, title = '' }) => {
  return (
    <GeneralLayout>
      <Grid
        container
        alignItems="center"
        justifyContent="center"
        direction="column"
        spacing={0}
        sx={{ minHeight: '80vh', backgroundColor: '#F9F9F9', padding: 4 }}
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
          }}
        >
          <Typography variant="h5" sx={{ mb: 1 }}>
            {title}
          </Typography>
          {children}
        </Grid>
      </Grid>
    </GeneralLayout>
  );
};

export default AuthLayout;
