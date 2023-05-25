package com.example.demo.service;

import com.example.demo.model.Pedido;
import com.example.demo.model.Usuario;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    PedidoRepository pedidoRepo;

    @Override
    public void creaPedido(Pedido p) {
        p.setActivo(true);
        pedidoRepo.save(p);
    }

    @Override
    public void borrarPedidoById(Integer id) {
        Optional<Pedido> o = pedidoRepo.findById(id);

        if (o.isPresent()) {
            o.get().setActivo(false);
            pedidoRepo.save(o.get());
        }
    }

    @Override
    public List<Pedido> obtenerPedidos() {
        return pedidoRepo.findAll();
    }

    @Override
    public Pedido obtenerPedidoById(Integer id) {

        Optional<Pedido> o = pedidoRepo.findById(id);

        if (o.isPresent()) {
            return o.get();
        }
        
        return null;
    }

	@Override
	public void guardarPedido(Pedido p) {
		pedidoRepo.save(p);
	}

	@Override
	public void habilitarPedidoById(Integer id) {
        Optional<Pedido> o = pedidoRepo.findById(id);

        if (o.isPresent()) {
            o.get().setActivo(true);
            pedidoRepo.save(o.get());
        }
		
	}

    @Override
    public Pedido obtenerPedidoByUsuarioAndEstado(Usuario u, Integer estado) {
        return pedidoRepo.findByUsuarioAndEstado(u , estado);
    }
}
