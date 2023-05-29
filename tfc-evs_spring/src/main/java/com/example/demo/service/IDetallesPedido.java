package com.example.demo.service;

import com.example.demo.model.DetallesPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;

import java.util.List;

public interface IDetallesPedido {
    void crearDetallesPedido(DetallesPedido dp);
    List<DetallesPedido> obtenerDetallesPedido();
    DetallesPedido obtenerDetallesPedidoById(Integer id);
    List<DetallesPedido> obtenerDetallesPedidoByPedido(Pedido p);
    DetallesPedido obtenerDetallesPedidoByPedidoAndProducto(Pedido pedido , Producto producto);
    void eliminarDetallesPedidoByid(Integer id);
}
