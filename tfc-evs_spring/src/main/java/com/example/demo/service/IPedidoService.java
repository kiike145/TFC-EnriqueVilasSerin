package com.example.demo.service;

import com.example.demo.model.Pedido;

import java.util.List;

public interface IPedidoService {

    void creaPedido(Pedido p);
    void borrarPedidoById(Integer id);
    List<Pedido> obtenerPedidos();
    Pedido obtenerPedidoById(Integer id);
}
