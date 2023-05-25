package com.example.demo.service;

import com.example.demo.model.DetallesPedido;
import com.example.demo.model.Pedido;

import java.util.List;

public interface IDetallesPedido {
    void crearDetallesPedido(DetallesPedido dp);
    List<DetallesPedido> obtenerDetallesPedido();
    DetallesPedido obtenerDetallesPedidoById(Integer id);
    List<DetallesPedido> obtenerDetallesPedidoByPedido(Pedido p);
}
