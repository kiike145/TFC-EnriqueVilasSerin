import { MenuItem, Select } from '@mui/material';
import React, { useState } from 'react';

const SelecctorUnidadesProducto = ({ dp }) => {
  const { producto } = dp;
  const [unidadesSeleccionadas, setUnidadesSeleccionadas] = useState(dp.cantidadproducto);

  const unidades = [];
  for (let i = 1; i <= producto.cantidad; i++) {
    unidades.push(
      <MenuItem key={i} value={i}>
        {i}
      </MenuItem>
    );
  }

  const onHandleChange = (event) => {
    const nuevaUnidadSeleccionada = +event.target.value;
    setUnidadesSeleccionadas(nuevaUnidadSeleccionada);

    fetch('http://localhost:8080/store/cart/', {
      method: 'PUT',
      body: JSON.stringify({
        id: dp.id,
        cantidadproducto: nuevaUnidadSeleccionada,
      }),
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
      },
    });
    window.location.reload();
  };

  return (
    <Select color="secondary" value={unidadesSeleccionadas} label="Cantidad" onChange={onHandleChange} sx={{ backgroundColor: 'white' }}>
      {unidades}
    </Select>
  );
};

export default SelecctorUnidadesProducto;
