import { Grid } from '@mui/material';
import React from 'react';
import ListaProductosCarroItem from './ListaProductosCarroItem';

const ListaProductosCarro = ({ productos = [] }) => {
  return (
    <Grid container width="60vw">
      {productos.map((dp) => (
        <ListaProductosCarroItem key={dp.id} producto={dp.producto} />
      ))}
    </Grid>
  );
};

export default ListaProductosCarro;
