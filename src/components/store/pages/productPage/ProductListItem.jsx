import { Box, Button, Grid } from '@mui/material';
import React from 'react';

const ProductListItem = ({ product = {} }) => {
  const isLogged = sessionStorage.getItem('isLogged');

  const handleOnClick = async () => {
    await fetch('http://localhost:8080/store/cart/', {
      method: 'POST',
      body: JSON.stringify({
        producto: { id: product.id },
        pedido: { id: sessionStorage.getItem('idPedido') },
      }),
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
      },
    });
  };

  return (
    <Box sx={{ m: 2, border: '1px solid black', p: 1, maxWidth: '14vw' }}>
      <img src={product.imagen} className="imagenProducto" />
      <Grid container justifyContent="space-between">
        <span className="nombreProducto">{product.nombre}</span> <span>{product.precio}€</span>
      </Grid>
      <Button fullWidth variant="contained" onClick={handleOnClick} disabled={isLogged === null}>
        Añadir
      </Button>
    </Box>
  );
};

export default ProductListItem;
