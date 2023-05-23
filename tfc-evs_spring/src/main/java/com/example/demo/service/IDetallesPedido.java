package com.example.demo.service;

import com.example.demo.model.DetallesPedido;

import java.util.List;

public interface IDetallesPedido {
    void crearDetallesPedido(DetallesPedido dp);
    List<DetallesPedido> obtenerDetallesPedido();
    DetallesPedido obtenerDetallesPedidoById(Integer id);
}
