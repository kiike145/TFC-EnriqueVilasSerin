import { Grid } from '@mui/material';
import React from 'react';
import ListaProductosCarroItem from './ListaProductosCarroItem';

const ListaProductosCarro = ({ detallesPedido = [] }) => {
  return (
    <Grid container width="60vw">
      {detallesPedido.map((dp) => (
        <ListaProductosCarroItem key={dp.id} dp={dp} />
      ))}
    </Grid>
  );
};

export default ListaProductosCarro;
