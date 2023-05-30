package com.example.demo.apiController;

import com.example.demo.model.Pedido;
import com.example.demo.model.Usuario;
import com.example.demo.service.IDetallesPedido;
import com.example.demo.service.IPedidoService;
import com.example.demo.service.IProductosService;
import com.example.demo.service.IUsuarioService;
import com.example.demo.utilities.Confimarcion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/store/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuariosControllerAPI {

    @Autowired
    IUsuarioService usuarioServ;
    @Autowired
    IPedidoService pedidoServ;

    @PostMapping("/signup")
    public ResponseEntity<Integer> registrarUsuario(@RequestBody Usuario user) {

        if (!usuarioServ.findUsuarioByNombreusuarioAndContrasena(user.getNombreusuario(), user.getContrasena())) {
        	
        	usuarioServ.crearUsuario(user);
        	
        	Confimarcion.enviarCorreoConfirmacionRegistro(user.getEmail(), user.getNombreusuario());
        	
        	Pedido p = new Pedido();
        	p.setUsuario(user);
        	p.setEstado(1);
        	p.setEstado(1);
        	pedidoServ.creaPedido(p);
        	
            return new ResponseEntity<>(pedidoServ.obtenerPedidoByUsuarioAndEstado(usuarioServ.getUsuarioByNombreusuarioAndContrasena(user.getNombreusuario(), user.getContrasena()), 1).getId()  , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/login")
    public ResponseEntity<Integer> loginUsuario(@RequestBody Usuario user) {

        if (usuarioServ.findUsuarioByNombreusuarioAndContrasena(user.getNombreusuario(), user.getContrasena())) { 
            return new ResponseEntity<>(pedidoServ.obtenerPedidoByUsuarioAndEstado(usuarioServ.getUsuarioByNombreusuarioAndContrasena(user.getNombreusuario(), user.getContrasena()), 1).getId() , HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
