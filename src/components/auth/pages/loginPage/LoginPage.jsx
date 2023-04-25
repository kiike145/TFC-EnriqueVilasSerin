import React from 'react';
import AuthLayout from '../../layout/AuthLayout';
import { Button, Grid, TextField } from '@mui/material';

const LoginPage = () => {
  return (
    <AuthLayout title="Login">
      <form>
        <Grid container>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="username" placeholder="Nombre de usuario" fullWidth />
          </Grid>

          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="password" placeholder="Contraseña" fullWidth />
          </Grid>

          <Grid item xs={12} sx={{ mt: 2 }}>
            <Button fullWidth variant="contained">
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
