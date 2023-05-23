import { Grid, Typography } from '@mui/material';
import React from 'react';
import GeneralLayout from '../../../../common/layout/GeneralLayout';

export const CartPage = () => {
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
        <Typography variant="h1" sx={{ mb: 1 }}>
          Carrito
        </Typography>
      </Grid>
    </GeneralLayout>
  );
};

export default CartPage;