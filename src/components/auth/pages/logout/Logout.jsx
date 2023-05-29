import React from 'react';

const Logout = () => {
  const handleClick = (event) => {
    sessionStorage.removeItem('isLogged');
    sessionStorage.removeItem('idPedido');
  };

  return (
    <a href="/login" onClick={handleClick}>
      Logout
    </a>
  );
};

export default Logout;
