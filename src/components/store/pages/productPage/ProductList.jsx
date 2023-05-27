import React from 'react';
import ProductListItem from './ProductListItem';
import { Grid } from '@mui/material';

const ProductList = ({ products = [] }) => {
  return (
    <Grid container>
      {products.map((product) => (
        <ProductListItem key={`product-${product.id}`} product={product} />
      ))}
    </Grid>
  );
};

export default ProductList;
