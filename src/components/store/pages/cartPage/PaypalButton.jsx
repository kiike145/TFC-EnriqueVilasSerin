import React from 'react';
import { PayPalButtons, PayPalScriptProvider } from '@paypal/react-paypal-js';
import { useNavigate } from 'react-router-dom';

const PaypalButton = ({ precioTotal }) => {
  const navigate = useNavigate();

  const cerrarPedido = () => {
    fetch('http://localhost:8080/store/pedido/', {
      method: 'POST',
      body: JSON.stringify({
        id: sessionStorage.getItem('idPedido'),
      }),
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
      },
    })
      .then((response) => response.json())
      .then((data) => sessionStorage.setItem('idPedido', JSON.stringify(data)));
  };

  return (
    <PayPalScriptProvider options={{ 'client-id': 'AeVySga1FWhG76BtDvYtMoJx4FWY5EZdlXMDZ-Iji9uP3p_YN0LdUjnC4BXiQkV_Sc9fRdNq91wlm8_V' }}>
      <PayPalButtons
        createOrder={(data, actions) => {
          return actions.order.create({
            purchase_units: [
              {
                amount: {
                  value: precioTotal,
                },
              },
            ],
          });
        }}
        onApprove={async (data, actions) => {
          const details = await actions.order.capture();
          const name = details.payer.name.given_name;
          alert('Transaction completed by ' + name);
          cerrarPedido();
          navigate('/');
        }}
      />
    </PayPalScriptProvider>
  );
};

export default PaypalButton;
