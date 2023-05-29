import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Box, Button, Grid, TextField } from '@mui/material';
import AuthLayout from '../../layout/AuthLayout';

import './signupForm.css';

const LoginPage = () => {
  const navigate = useNavigate();

  const [errorMsg, setErrorMsg] = useState('');
  const [formState, setFormState] = useState({
    nombreusuario: '',
    contrasena: '',
  });

  const handleChange = (event) => {
    setFormState({
      ...formState,
      [event.target.name]: event.target.value,
    });
  };

  const logIn = () => {
    fetch('http://localhost:8080/store/users/login/', {
      method: 'POST',
      body: JSON.stringify({
        nombreusuario: formState.nombreusuario,
        contrasena: formState.contrasena,
      }),
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
      },
    })
      .then((response) => {
        if (response.status === 200) {
          return response.json();
        } else {
          throw new Error('Error en la solicitud');
        }
      })
      .then((data) => {
        sessionStorage.setItem('isLogged', true);
        sessionStorage.setItem('idPedido', JSON.stringify(data));
      })
      .catch((error) => {
        setErrorMsg('Usuario o contraseña incorrectos, revise los datos');
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    setErrorMsg();
    logIn();
    navigate('/');
  };

  return (
    <AuthLayout title="Login">
      <form onSubmit={handleSubmit}>
        <Grid container>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField
              name="nombreusuario"
              label="Nombre de usuario"
              color="secondary"
              onChange={handleChange}
              fullWidth
            />
          </Grid>

          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField
              name="contrasena"
              label="Contraseña"
              type="password"
              color="secondary"
              onChange={handleChange}
              fullWidth
            />
          </Grid>

          <Grid item xs={12} sx={{ mt: 2 }}>
            <Button fullWidth variant="contained" type="submit">
              <strong>Inicar sesión</strong>
            </Button>

            {errorMsg && (
              <Box className="error" sx={{ mt: 2 }}>
                {errorMsg}
              </Box>
            )}
          </Grid>
        </Grid>
      </form>
      <Grid container direction="row" justifyContent="end" sx={{ mt: 2 }}>
        <a href="/signup">Crear cuenta</a>
      </Grid>
    </AuthLayout>
  );
};

export default LoginPage;
