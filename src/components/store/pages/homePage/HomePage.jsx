import React, { useState } from 'react';
import { Grid, Typography } from '@mui/material';
import GeneralLayout from '../../../../common/layout/GeneralLayout';
import { useEffect } from 'react';
import Article from './Article';

export const HomePage = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/store/prods/destacados')
      .then((response) => response.json())
      .then((data) => setProducts(data));
  }, []);

  return (
    <GeneralLayout>
      <Typography variant="h1">Hola!</Typography>
      <Grid container direction="row" wrap="wrap" justifyContent="space-around">
        <Grid>banner</Grid>
        <Grid>
          <h3>Artículos destacados</h3>
          {products.map((product) => (
            <Article key={`product-${product.id}`} product={product} />
          ))}
        </Grid>
      </Grid>
    </GeneralLayout>
  );
};
