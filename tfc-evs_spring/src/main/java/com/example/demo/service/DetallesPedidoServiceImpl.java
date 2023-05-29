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
    public void crearDetallesPedido(DetallesPedido detallesPedido) {
    	
    	DetallesPedido dp = new DetallesPedido();
    	dp.setPedido(detallesPedido.getPedido());
    	dp.setProducto(detallesPedido.getProducto());
    	
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
        return detallesPedidoRepo.findByPedido(p);
    }

	@Override
	public DetallesPedido obtenerDetallesPedidoByPedidoAndProducto(Pedido pedido, Producto producto) {
		return detallesPedidoRepo.findByPedidoAndProducto(pedido, producto);
	}

	@Override
	public void eliminarDetallesPedidoByid(Integer id) {
		detallesPedidoRepo.deleteById(id);
	}
}
