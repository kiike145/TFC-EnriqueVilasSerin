package com.example.demo.service;

import com.example.demo.model.DetallesPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.repository.DetallesPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DetallesPedidoServiceImpl implements IDetallesPedido {

    @Autowired
    DetallesPedidoRepository detallesPedidoRepo;

    @Override
    public void crearDetallesPedido(DetallesPedido dp) {
        detallesPedidoRepo.save(dp);
    }

    @Override
    public List<DetallesPedido> obtenerDetallesPedido() {
        return detallesPedidoRepo.findAll();
    }

    @Override
    public DetallesPedido obtenerDetallesPedidoById(Integer id) {

        Optional<DetallesPedido> o = detallesPedidoRepo.findById(id);

        if (o.isPresent()) {
            return o.get();
        }

        return null;
    }

    @Override
    public List<DetallesPedido> obtenerDetallesPedidoByPedido(Pedido p) {

        List<DetallesPedido> lista = new LinkedList<>();

        for (DetallesPedido dps : detallesPedidoRepo.findByPedido(p)) {

            DetallesPedido dpAux = new DetallesPedido();
            Pedido pedidoAux = new Pedido();

            pedidoAux.setId(dps.getPedido().getId());
            pedidoAux.setPreciototal(dps.getPedido().getPreciototal());

            dpAux.setId(dps.getId());
            dpAux.setPedido(pedidoAux);
            dpAux.setProducto(dps.getProducto());
            dpAux.setCantidadproducto(dps.getCantidadproducto());

            lista.add(dpAux);
        }

//        return detallesPedidoRepo.findByPedido(p);
        return lista;
    }
}
