import React from 'react';
import AuthLayout from '../../layout/AuthLayout';
import { Button, Grid, TextField } from '@mui/material';

const SignUpPage = () => {
  return (
    <AuthLayout title="SignUp">
      <form>
        <Grid container>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="name" type="text" label="Nombre" color="secondary" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="lastname" type="text" label="Apellidos" color="secondary" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="username" type="text" label="Nombre de usuario" color="secondary" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="password" type="password" label="Contraseña" color="secondary" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="email" type="email" label="Email" color="secondary" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            Fecha naciemiento
          </Grid>

          <Grid item xs={12} sx={{ mt: 2 }}>
            <Button fullWidth variant="contained">
              <strong>Crear cuenta</strong>
            </Button>
          </Grid>

          <Grid container direction="row" justifyContent="end" sx={{ mt: 2 }}>
            <span>¿Ya tienes cuenta?</span>&nbsp;
            <a href="/login">Inicar sesión</a>
          </Grid>
        </Grid>
      </form>
    </AuthLayout>
  );
};

export default SignUpPage;
