import React from 'react';
import { Route, Routes } from 'react-router-dom';
import LoginPage from '../../components/auth/pages/loginPage/LoginPage';
import SignUpPage from '../../components/auth/pages/signupPage/SignUpPage';

const AuthRoutes = () => {
  return (
    <Routes>
      <Route path="/login" element={<LoginPage />} />
      <Route path="/signup" element={<SignUpPage />} />
    </Routes>
  );
};

export default AuthRoutes;
