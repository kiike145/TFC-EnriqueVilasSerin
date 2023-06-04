import React, { useEffect, useState } from 'react';
import { Grid, Typography } from '@mui/material';
import GeneralLayout from '../../../../common/layout/GeneralLayout';
import ProductList from './ProductList';

export const ProductsPage = () => {
  const [product, setProduct] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/store/prods/')
      .then((response) => response.json())
      .then((data) => setProduct(data));
  }, []);

  return (
    <GeneralLayout>
      <Grid container direction="column" spacing={0} sx={{ minHeight: '80vh', backgroundColor: '#F9F9F9', paddingLeft: 3, paddingRight: 3 }}>
        <Typography variant="h5" sx={{ pl: 2, pt: 2 }}>
          Productos
        </Typography>
        {/* <Box className="box-shadow" sx={{ maxWidth: '11vw', padding: 3, backgroundColor: '#EFEFEF' }}>
          <form action="" method="post">
            <TextField name="filtro" label="Filtro" type="password" color="secondary" fullWidth />
            <FormControlLabel value="Teclado" control={<Checkbox />} label="Teclado" labelPlacement="end" sx={{ flexWrap: 'wrap' }} />
            <FormControlLabel value="Switch" control={<Checkbox />} label="Switch" labelPlacement="end" sx={{ flexWrap: 'wrap' }} />
            <FormControlLabel value="Keycaps" control={<Checkbox />} label="Keycaps" labelPlacement="end" sx={{ flexWrap: 'wrap' }} />
            <FormControlLabel value="Cables" control={<Checkbox />} label="Cables" labelPlacement="end" sx={{ flexWrap: 'wrap' }} />
            <FormControlLabel value="Herramientas" control={<Checkbox />} label="Herramientas" labelPlacement="end" sx={{ flexWrap: 'wrap' }} />
            <Button fullWidth variant="contained" type="submit">
              <strong>Buscar</strong>
            </Button>
          </form>
        </Box> */}
        <ProductList products={product} />
      </Grid>
    </GeneralLayout>
  );
};

export default ProductsPage;
