import React, { useState } from 'react';

const SelecctorUnidadesProducto = ({ dp }) => {
  const { producto } = dp;
  const [unidadesSeleccionadas, setUnidadesSeleccionadas] = useState(dp.cantidadproducto);

  const unidades = [];
  for (let i = 1; i <= producto.cantidad; i++) {
    unidades.push(
      <option key={i} value={i}>
        {i}
      </option>
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
    <select value={unidadesSeleccionadas} onChange={onHandleChange}>
      {unidades}
    </select>
  );
};

export default SelecctorUnidadesProducto;
