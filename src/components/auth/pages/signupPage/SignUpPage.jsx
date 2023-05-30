import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Box, Button, Grid, TextField } from '@mui/material';
import AuthLayout from '../../layout/AuthLayout';

const SignUpPage = () => {
  const navigate = useNavigate();

  const [error, setError] = useState('');
  const [formState, setFormState] = useState({
    nombre: '',
    apellido: '',
    nombreusuario: '',
    contrasena: '',
    email: '',
    fechanacimiento: '',
    direction: '',
  });

  const handleChange = (event) => {
    const fechaNacimiento = new Date(formState.fechanacimiento);
    const edad = new Date().getFullYear() - fechaNacimiento.getFullYear();

    if (edad < 18) {
      setError('Hay que ser mayor de edad');
      return;
    }

    setFormState({
      ...formState,
      [event.target.name]: event.target.value,
    });
  };

  const saveUser = () => {
    fetch('http://localhost:8080/store/users/signup', {
      method: 'POST',
      body: JSON.stringify({
        nombre: formState.name,
        apellidos: formState.lastname,
        nombreusuario: formState.nombreusuario,
        contrasena: formState.contrasena,
        email: formState.email,
        fechanacimiento: formState.fechanacimiento,
        direccion: formState.direction,
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
        setError('Usuario o contraseña incorrectos, revise los datos');
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    setError('');
    saveUser();
    navigate('/');
  };

  return (
    <AuthLayout title="SignUp">
      <form onSubmit={handleSubmit}>
        <Grid container>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="name" type="text" label="Nombre" color="secondary" onChange={handleChange} fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="lastname" type="text" label="Apellidos" color="secondary" onChange={handleChange} fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="direccion" type="text" label="Dirección" color="secondary" onChange={handleChange} fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="fechanacimiento" type="date" label="Fecha nacimiento" color="secondary" onChange={handleChange} fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="nombreusuario" type="text" label="Nombre de usuario" color="secondary" onChange={handleChange} fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="email" type="email" label="Email" color="secondary" onChange={handleChange} fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="contrasena" type="password" label="Contraseña" color="secondary" onChange={handleChange} fullWidth />
          </Grid>

          <Grid item xs={12} sx={{ mt: 2 }}>
            <Button fullWidth variant="contained" type="submit">
              <strong>Crear cuenta</strong>
            </Button>
            {error && (
              <Box className="error" sx={{ mt: 2 }}>
                {error}
              </Box>
            )}
          </Grid>

          <Grid container direction="row" justifyContent="end" sx={{ mt: 2 }}>
            <span>¿Ya tienes cuenta?</span>&nbsp;
            <a href="/login">Iniciar sesión</a>
          </Grid>
        </Grid>
      </form>
    </AuthLayout>
  );
};

export default SignUpPage;
