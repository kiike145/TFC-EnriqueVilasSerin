import React from 'react';

const Article = ({ product = {} }) => {
  return <img src={product.imagen} className="productHome" />;
};

export default Article;
