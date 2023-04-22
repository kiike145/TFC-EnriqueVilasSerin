import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import AuthRoutes from './AuthRoutes';

const AppRoutes = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/auth/*" element={<AuthRoutes />} />
      </Routes>
    </BrowserRouter>
  );
};

export default AppRoutes;
