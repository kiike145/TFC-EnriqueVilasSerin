package com.example.demo.apiController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pedido;
import com.example.demo.service.IDetallesPedido;
import com.example.demo.service.IPedidoService;
import com.example.demo.service.IUsuarioService;


@RestController
@RequestMapping(value = "/store/pedido")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoControllerAPI {
	
    @Autowired
    IDetallesPedido detallesPedidoServ;
    @Autowired
    IPedidoService pedidoServ;
    @Autowired
    IUsuarioService usuarioServ;
	
    @PostMapping("/")
    public ResponseEntity<Integer> cerrarPedido(@RequestBody Pedido pedido) {
    	
    	Pedido pedidoAux = pedidoServ.obtenerPedidoById(pedido.getId());
    	
    	pedidoServ.cerrarPedidoById(detallesPedidoServ.obtenerDetallesPedidoByIdPedido(pedido.getId()) , pedido.getId());
    	return new ResponseEntity<>(pedidoServ.obtenerPedidoByUsuarioAndEstado(usuarioServ.getUsuarioByNombreusuarioAndContrasena(pedidoAux.getUsuario().getNombreusuario(), pedidoAux.getUsuario().getContrasena()), 1).getId() , HttpStatus.OK);
    }

}
