import React from 'react';
import { Link as RouterLink } from 'react-router-dom';
import AuthLayout from '../../layout/AuthLayout';
import { Button, Grid, Link, TextField } from '@mui/material';
import DateFormPicker from './DatePicker';

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
            <DateFormPicker />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="username" type="text" label="Nombre de usuario" color="secondary" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="email" type="email" label="Email" color="secondary" fullWidth />
          </Grid>
          <Grid item xs={12} sx={{ mt: 2 }}>
            <TextField name="password" type="password" label="Contraseña" color="secondary" fullWidth />
          </Grid>

          <Grid item xs={12} sx={{ mt: 2 }}>
            <Button fullWidth variant="contained">
              <strong>Crear cuenta</strong>
            </Button>
          </Grid>

          <Grid container direction="row" justifyContent="end" sx={{ mt: 2 }}>
            <span>¿Ya tienes cuenta?</span>&nbsp;
            <Link component={RouterLink} to="/login" underline="hover" sx={{ color: '#490178' }}>
              Iniciar sesión
            </Link>
          </Grid>
        </Grid>
      </form>
    </AuthLayout>
  );
};

export default SignUpPage;
