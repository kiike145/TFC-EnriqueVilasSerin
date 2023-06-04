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
	@Autowired
	IPedidoService pedidoServ;
	@Autowired
	IProductosService productoServ;

    @Override
    public void crearDetallesPedido(DetallesPedido detallesPedido) {
    	
    	if (detallesPedido.getCantidadproducto() == null) {
    		detallesPedido.setCantidadproducto(1);
    	}
    	
    	Pedido pedidoAux = pedidoServ.obtenerPedidoById(detallesPedido.getPedido().getId());
    	Float precioASumar = productoServ.obtenerProductoById(detallesPedido.getProducto().getId()).getPrecio() * detallesPedido.getCantidadproducto();
    	
    	if (pedidoAux.getPreciototal() == null) {
    		pedidoAux.setPreciototal(precioASumar);
    	} else {
    		pedidoAux.setPreciototal(pedidoAux.getPreciototal() + precioASumar);
    	}

    	pedidoServ.guardarPedido(pedidoAux);
        detallesPedidoRepo.save(detallesPedido);
    }
    
	@Override
	public void actulizarDetallesPedido(DetallesPedido dp) {
		Optional<DetallesPedido> o = detallesPedidoRepo.findById(dp.getId());
		
		if (o.isPresent()) {
			
			Integer cantidadVieja = o.get().getCantidadproducto();
			Integer cantidadNueva = dp.getCantidadproducto();
			
	    	Pedido pedidoAux = pedidoServ.obtenerPedidoById(o.get().getPedido().getId());
	    	Producto prodAux = productoServ.obtenerProductoById(o.get().getProducto().getId());
	    	
	    	Float precioNuevo = (float) 0.0;
	    	precioNuevo = prodAux.getPrecio() * cantidadNueva - prodAux.getPrecio() * cantidadVieja;
			
			o.get().setCantidadproducto(dp.getCantidadproducto());

	    	pedidoAux.setPreciototal(pedidoAux.getPreciototal() + precioNuevo);
            
            pedidoServ.guardarPedido(pedidoAux);
            detallesPedidoRepo.save(o.get());
        }
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
    public List<DetallesPedido> obtenerDetallesPedidoByIdPedido(Integer idPedido) {
    	
    	List<DetallesPedido> listaAux = new LinkedList<>();
    	
    	for (DetallesPedido dp : detallesPedidoRepo.findByPedido(pedidoServ.obtenerPedidoById(idPedido))) {
    		
    		if (dp.getProducto().getCantidad() > 0) {
    			listaAux.add(dp);
    		}
    	}
    	
        return listaAux;
    }

	@Override
	public DetallesPedido obtenerDetallesPedidoByPedidoAndProducto(DetallesPedido dp) {
		
		Pedido pedido = dp.getPedido();
		Producto producto = dp.getProducto();
		
		return detallesPedidoRepo.findByPedidoAndProducto(pedido, producto);
	}

	@Override
	public void eliminarDetallesPedidoByid(Integer id) {
		
		Optional<DetallesPedido> o = detallesPedidoRepo.findById(id);
		
		if (o.isPresent()) {
			
			Pedido pedidoAux = pedidoServ.obtenerPedidoById(o.get().getPedido().getId());
	    	Float precioARestar = productoServ.obtenerProductoById(o.get().getProducto().getId()).getPrecio() * o.get().getCantidadproducto();
	    	
	    	pedidoAux.setPreciototal(pedidoAux.getPreciototal() - precioARestar);
	    	pedidoServ.guardarPedido(pedidoAux);
        }
		
		detallesPedidoRepo.deleteById(id);
	}
}
