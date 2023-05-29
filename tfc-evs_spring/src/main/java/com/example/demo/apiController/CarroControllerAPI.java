package com.example.demo.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DetallesPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
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

	
	@GetMapping("/{idPedido}")
	public List<DetallesPedido> devolverProductosByPedido(@PathVariable("idPedido") Integer idPedido) {
		return detallesPedidoServ.obtenerDetallesPedidoByIdPedido(idPedido);
	}
	
    @PostMapping("/")
    public void addProductoToPedido(@RequestBody DetallesPedido detallesPedido) {   	
    	detallesPedidoServ.crearDetallesPedido(detallesPedido);
    }
    
    @PutMapping("/")
    public void updateProductoToPedido(@RequestBody DetallesPedido detallesPedido) {
    	detallesPedidoServ.actulizarDetallesPedido(detallesPedido);
    }
	
	@DeleteMapping("/")
	public void eliminarProductosByPedido(@RequestBody DetallesPedido dp) {
		DetallesPedido dpAux = detallesPedidoServ.obtenerDetallesPedidoByPedidoAndProducto(dp);
		detallesPedidoServ.eliminarDetallesPedidoByid(dpAux.getId());
	}
	
	@GetMapping("/price/{idPedido}")
	public Float devolverPrecioByPedido(@PathVariable("idPedido") Integer idPedido) {
		return pedidoServ.obtenerPedidoById(idPedido).getPreciototal();
	}
}
