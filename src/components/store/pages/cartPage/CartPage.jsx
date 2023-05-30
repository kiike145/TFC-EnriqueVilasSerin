import { Box, Button, Grid, Typography } from '@mui/material';
import React, { useEffect, useState } from 'react';
import GeneralLayout from '../../../../common/layout/GeneralLayout';
import ListaProductosCarro from './ListaProductosCarro';
import PaypalButton from './PaypalButton';

export const CartPage = () => {
  const [detallesPedido, setDetallesPedido] = useState([]);
  const [precioTotal, setPrecioTotal] = useState(0);
  const isLogged = sessionStorage.getItem('isLogged');

  useEffect(() => {
    fetch('http://localhost:8080/store/cart/' + sessionStorage.getItem('idPedido'))
      .then((response) => response.json())
      .then((data) => {
        if (data.status !== 400) {
          setDetallesPedido(data);
        }
      });
  }, []);

  useEffect(() => {
    fetch('http://localhost:8080/store/cart/price/' + sessionStorage.getItem('idPedido'))
      .then((response) => response.json())
      .then((data) => {
        if (data.status !== 400) {
          setPrecioTotal(data);
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
          {isLogged === null ? <p className="infoMsg">No hay ningun artículo</p> : <ListaProductosCarro detallesPedido={detallesPedido} />}

          {isLogged === null ? (
            ''
          ) : (
            <Grid container width="10vw" direction="column">
              Total: {precioTotal}$
              <Box>
                {/* <Button variant="contained">Tramitar pedido</Button> */}
                <PaypalButton precioTotal={precioTotal} />
              </Box>
            </Grid>
          )}
        </Grid>
      </Grid>
    </GeneralLayout>
  );
};

export default CartPage;
