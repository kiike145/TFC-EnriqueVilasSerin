package com.example.demo.repository;

import com.example.demo.model.DetallesPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;
import java.util.List;

public interface DetallesPedidoRepository extends JpaRepository<DetallesPedido, Integer> {
    List<DetallesPedido> findByPedido(Pedido p);
    DetallesPedido findByPedidoAndProducto(Pedido pedido , Producto producto);

    @Query(
        value = "select sum(prod.precio * dp.cantidadProducto) as precioTotal from pedidos ped" +
                "   inner join detallesPedido dp on ped.id = dp.idPedido" +
                "   inner join productos prod on dp.idProducto = prod.id" +
                "   where ped.id = ?",
        nativeQuery = true)
    Float getPrecioTotalByPedido(Integer idPedido);
}
