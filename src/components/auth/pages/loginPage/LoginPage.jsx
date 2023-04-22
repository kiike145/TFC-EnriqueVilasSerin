import React from 'react';
import AuthLayout from '../../layout/AuthLayout';
import { Button, Grid, TextField } from '@mui/material';
import { Link } from 'react-router-dom';

const LoginPage = () => {
  return (
    <AuthLayout title="Login Page">
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
              Login
            </Button>
          </Grid>

          <Grid container direction="row" justifyContent="end" sx={{ mt: 2 }}>
            <Link>Crear cuenta</Link>
          </Grid>
        </Grid>
      </form>
    </AuthLayout>
  );
};

export default LoginPage;
