package com.example.demo.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DetallesPedido;
import com.example.demo.model.Pedido;
import com.example.demo.service.IDetallesPedido;
import com.example.demo.service.IPedidoService;
import com.example.demo.service.IProductosService;

@RestController
@RequestMapping(value = "/store/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CarroControllerAPI {
	
	@Autowired
	IDetallesPedido detallesPedidoServ;
	@Autowired
	IPedidoService pedidoServ;
	@Autowired
	IProductosService productoServ;
	
	@GetMapping("/{idPedido}")
	public List<DetallesPedido> devolverProductosByPedido(@PathVariable("idPedido") Integer idPedido) {
		return detallesPedidoServ.obtenerDetallesPedidoByPedido(pedidoServ.obtenerPedidoById(idPedido));
	}

}
