import { Box, Button, Grid } from '@mui/material';
import React from 'react';

import './products.css';

const ProductListItem = ({ product = {} }) => {
  return (
    <Box sx={{ m: 2, border: '1px solid black', p: 1, maxWidth: '14vw', bgcolor: '' }}>
      <img src={product.imagen} />
      <Grid container justifyContent="space-between">
        <span className="nombreProducto">{product.nombre}</span> <span>{product.precio}€</span>
      </Grid>
      <Button fullWidth variant="contained" type="submit">
        Ver detalles
      </Button>
    </Box>
  );
};

export default ProductListItem;
