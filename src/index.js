import React from 'react';
import ReactDOM from 'react-dom/client';
import reportWebVitals from './reportWebVitals';
import AppRoutes from './common/routes/AppRoutes';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AppRoutes></AppRoutes>
  </React.StrictMode>
);

reportWebVitals();
