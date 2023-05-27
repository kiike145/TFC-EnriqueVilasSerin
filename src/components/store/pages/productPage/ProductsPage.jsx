import React, { useEffect, useState } from 'react';
import { Box, Button, Checkbox, FormControlLabel, Grid, TextField, Typography } from '@mui/material';
import GeneralLayout from '../../../../common/layout/GeneralLayout';
import ProductList from './ProductList';

export const ProductsPage = () => {
  const [product, setProduct] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/store/prods/')
      .then((response) => response.json())
      .then((data) => setProduct(data));
  }, []);

  return (
    <GeneralLayout>
      <Typography variant="h5" sx={{ padding: 2 }}>
        Productos
      </Typography>
      <Grid container direction="row" spacing={0} sx={{ backgroundColor: '#F9F9F9', paddingLeft: 3, paddingRight: 3 }}>
        <Box className="box-shadow" sx={{ maxWidth: '11vw', padding: 3, backgroundColor: '#EFEFEF' }}>
          <form action="" method="post">
            <TextField name="filtro" label="Filtro" type="password" color="secondary" fullWidth />
            <FormControlLabel
              value="Teclado"
              control={<Checkbox />}
              label="Teclado"
              labelPlacement="end"
              sx={{ flexWrap: 'wrap' }}
            />
            <FormControlLabel
              value="Switch"
              control={<Checkbox />}
              label="Switch"
              labelPlacement="end"
              sx={{ flexWrap: 'wrap' }}
            />
            <FormControlLabel
              value="Keycaps"
              control={<Checkbox />}
              label="Keycaps"
              labelPlacement="end"
              sx={{ flexWrap: 'wrap' }}
            />
            <FormControlLabel
              value="Cables"
              control={<Checkbox />}
              label="Cables"
              labelPlacement="end"
              sx={{ flexWrap: 'wrap' }}
            />
            <FormControlLabel
              value="Herramientas"
              control={<Checkbox />}
              label="Herramientas"
              labelPlacement="end"
              sx={{ flexWrap: 'wrap' }}
            />
            <Button fullWidth variant="contained" type="submit">
              <strong>Buscar</strong>
            </Button>
          </form>
        </Box>
        <Grid sx={{ maxWidth: '90vw' }}>
          <ProductList products={product} />
        </Grid>
      </Grid>
    </GeneralLayout>
  );
};

export default ProductsPage;
