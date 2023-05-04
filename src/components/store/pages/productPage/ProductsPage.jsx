import React from 'react';
import { Grid } from '@mui/material';
import GeneralLayout from '../../../../common/layout/GeneralLayout';

export const ProductsPage = () => {
  return (
    <GeneralLayout>
      <Grid
        container
        alignItems="center"
        justifyContent="center"
        direction="column"
        spacing={0}
        sx={{ minHeight: '80vh', backgroundColor: '#F9F9F9', padding: 4 }}
      ></Grid>
    </GeneralLayout>
  );
};

export default ProductsPage;
