import React from 'react';
import SelecctorUnidadesProducto from './SelecctorUnidadesProducto';
import { Button, Grid } from '@mui/material';

const ListaProductosCarroItem = ({ producto = {} }) => {
  const handleOnClick = async () => {
    await fetch('http://localhost:8080/store/cart/', {
      method: 'DELETE',
      body: JSON.stringify({
        producto: { id: producto.id },
        pedido: { id: sessionStorage.getItem('idPedido') },
      }),
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
      },
    });

    window.location.reload();
  };

  return (
    <Grid container justifyContent="space-between">
      <Grid container sx={{ maxWidth: '30vw' }}>
        <img src={producto.imagen} alt={producto.nombre} className="imagenCarro" />
        &nbsp;
        <span>{producto.nombre}</span>
      </Grid>
      <Grid>
        <h3>{producto.precio}€</h3>
        <SelecctorUnidadesProducto producto={producto} />
        <Button variant="contained" sx={{ m: 1 }} onClick={handleOnClick}>
          Eliminar
        </Button>
      </Grid>
    </Grid>
  );
};

export default ListaProductosCarroItem;
