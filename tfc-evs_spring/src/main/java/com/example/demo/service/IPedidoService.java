package com.example.demo.service;

import com.example.demo.model.DetallesPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Usuario;

import java.util.List;

public interface IPedidoService {

    void creaPedido(Pedido p);
    void borrarPedidoById(Integer id);
    List<Pedido> obtenerPedidos();
    Pedido obtenerPedidoById(Integer id);
	void guardarPedido(Pedido p);
	void habilitarPedidoById(Integer id);
    Pedido obtenerPedidoByUsuarioAndEstado(Usuario u , Integer estado);
    void cerrarPedidoById(List<DetallesPedido> dp , Integer idPedido);
}
