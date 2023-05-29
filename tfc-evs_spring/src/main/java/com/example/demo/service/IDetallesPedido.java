package com.example.demo.service;

import com.example.demo.model.DetallesPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;

import java.util.List;

public interface IDetallesPedido {
    void crearDetallesPedido(DetallesPedido dp);
    void actulizarDetallesPedido(DetallesPedido dp);
    List<DetallesPedido> obtenerDetallesPedido();
    DetallesPedido obtenerDetallesPedidoById(Integer id);
    List<DetallesPedido> obtenerDetallesPedidoByIdPedido(Integer idPedido);
    DetallesPedido obtenerDetallesPedidoByPedidoAndProducto(DetallesPedido dp);
    void eliminarDetallesPedidoByid(Integer id);
}
