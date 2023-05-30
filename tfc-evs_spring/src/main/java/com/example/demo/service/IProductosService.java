package com.example.demo.service;

import com.example.demo.model.Producto;

import java.util.List;

public interface IProductosService {

    void guardarProducto(Producto p);
    void borrarProductoById(Integer id);
    void habilitarProductoById(Integer id);
    void actualizarProdcuto(Producto p);
    Producto obtenerProductoById(Integer id);
    List<Producto> obtenerProductos();
    List<Producto> obtenerProductosDestacados();
    List<Producto> obtenerProductosActivos();
}
