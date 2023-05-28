import React from 'react';

const Logout = () => {
  const handleClick = (event) => {
    sessionStorage.removeItem('isLogged');
    sessionStorage.removeItem('carrito');
  };

  return (
    <a href="/login" onClick={handleClick}>
      Logout
    </a>
  );
};

export default Logout;
