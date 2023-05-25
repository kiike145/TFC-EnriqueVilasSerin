import React, { useState } from 'react';
import AuthLayout from '../../layout/AuthLayout';
import { Button, Grid, TextField } from '@mui/material';

const LoginPage = () => {
  const [error, setError] = useState([]); // Mostrarle los errores al usuario
  const [formState, setFormState] = useState({
    // Datos por defecto del formulario (vacio)
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
    }).then((data) => {
      if (data.status === 200) {
        sessionStorage.setItem('isLogged', true);
      }
      if (data.status === 400) {
        setError('User not found');
      }
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    setError('');
    logIn();
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
