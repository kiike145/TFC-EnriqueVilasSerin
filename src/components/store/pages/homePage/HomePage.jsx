import React, { useState } from 'react';
import { Box, Grid, Typography } from '@mui/material';
import GeneralLayout from '../../../../common/layout/GeneralLayout';
import { useEffect } from 'react';
import Article from './Article';

import banner from '../../../../assert/banner.jpeg';

export const HomePage = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/store/prods/destacados')
      .then((response) => response.json())
      .then((data) => setProducts(data));
  }, []);

  return (
    <GeneralLayout>
      <Grid container direction="column" justifyContent="center" alignItems="center" spacing={0} sx={{ minHeight: '80vh', backgroundColor: '#F9F9F9', paddingLeft: 3, paddingRight: 3 }}>
        <img src={banner} alt="banner del la pagina principal" className="banner" />
        <Typography variant="h1" sx={{ fontSize: '3rem' }}>
          ¡Bienveni@ a ePeriph!
        </Typography>
        <Box sx={{ textAlign: 'justify', width: '50vw' }}>
          Tu destino en línea para todo lo relacionado con periféricos de ordenador. En ePeriph, nos apasiona proporcionarte una experiencia de compra sin complicaciones y una amplia selección de
          productos de alta calidad. Nuestro equipo de expertos en tecnología ha seleccionado cuidadosamente cada producto en nuestro catálogo para garantizar su rendimiento, durabilidad y valor
          excepcional. Con precios competitivos y un servicio al cliente excepcional, en ePeriph estamos comprometidos a hacer que tu experiencia de compra sea impecable
        </Box>
        <Grid>
          <Typography variant="h4" textAlign="center">
            Artículos destacados
          </Typography>
          {products.map((product) => (
            <Article key={`product-${product.id}`} product={product} />
          ))}
        </Grid>
      </Grid>
    </GeneralLayout>
  );
};
