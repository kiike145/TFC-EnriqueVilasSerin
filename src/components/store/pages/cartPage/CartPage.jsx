import { Box, Button, Grid, Typography } from '@mui/material';
import React, { useEffect, useState } from 'react';
import GeneralLayout from '../../../../common/layout/GeneralLayout';
import ListaProductosCarro from './ListaProductosCarro';

export const CartPage = () => {
  const [productos, setProductos] = useState([]);
  const isLogged = sessionStorage.getItem('isLogged');

  useEffect(() => {
    fetch('http://localhost:8080/store/cart/' + sessionStorage.getItem('idPedido'))
      .then((response) => response.json())
      .then((data) => {
        if (data.status !== 400) {
          setProductos(data);
        }
      });
  }, []);

  return (
    <GeneralLayout>
      <Grid container direction="column" spacing={0} sx={{ minHeight: '80vh', backgroundColor: '#F9F9F9', paddingLeft: 3, paddingRight: 3 }}>
        <Typography variant="h5" sx={{ padding: 2 }}>
          Carrito
        </Typography>

        <Grid container justifyContent="space-around">
          {isLogged === null ? <p className="infoMsg">No hay ningun artículo</p> : <ListaProductosCarro productos={productos} />}

          {isLogged === null ? (
            ''
          ) : (
            <Grid container width="10vw" direction="column">
              Total: €
              <Box>
                <Button variant="contained">Tramitar pedido</Button>
              </Box>
            </Grid>
          )}
        </Grid>
      </Grid>
    </GeneralLayout>
  );
};

export default CartPage;
