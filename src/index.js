import React from 'react';
import ReactDOM from 'react-dom/client';
import reportWebVitals from './reportWebVitals';
import AppRoutes from './common/routes/AppRoutes';
import AppTheme from './theme/AppTheme';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AppTheme>
      <AppRoutes />
    </AppTheme>
  </React.StrictMode>
);

reportWebVitals();
