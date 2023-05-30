package com.example.demo.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pedido;
import com.example.demo.service.IDetallesPedido;
import com.example.demo.service.IPedidoService;


@RestController
@RequestMapping(value = "/store/pedido")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoControllerAPI {
	
    @Autowired
    IDetallesPedido detallesPedidoServ;
    @Autowired
    IPedidoService pedidoServ;
	
    @PostMapping("/")
    public void cerrarPedido(@RequestBody Pedido pedido) {
    	pedidoServ.cerrarPedidoById(detallesPedidoServ.obtenerDetallesPedidoByIdPedido(pedido.getId()) , pedido.getId());
    	
    }

}
