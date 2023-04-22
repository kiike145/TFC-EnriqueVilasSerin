import React from 'react';
import AuthLayout from '../../layout/AuthLayout';
import { Button, Grid, TextField } from '@mui/material';
import { Link } from 'react-router-dom';

const SignUpPage = () => {
  return (
    <AuthLayout title="SignUp Page">
      <form>
        <Grid container>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="name" placeholder="Nombre" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="lastanem" placeholder="Apellidos" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="username" placeholder="Nombre de usuario" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="password" placeholder="Contraseña" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="email" placeholder="Email" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="email" placeholder="Email" fullWidth />
          </Grid>

          <Grid item xs={12} sx={{ mt: 2 }}>
            <Button fullWidth variant="contained">
              Crear cuenta
            </Button>
          </Grid>

          <Grid container direction="row" justifyContent="end" sx={{ mt: 2 }}>
            <span>¿Ya tienes cuenta?</span>&nbsp;
            <Link>Iniciar sesión</Link>
          </Grid>
        </Grid>
      </form>
    </AuthLayout>
  );
};

export default SignUpPage;
