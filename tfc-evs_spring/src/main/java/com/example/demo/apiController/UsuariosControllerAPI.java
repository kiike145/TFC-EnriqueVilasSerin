package com.example.demo.apiController;

import com.example.demo.model.DetallesPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Usuario;
import com.example.demo.service.IDetallesPedido;
import com.example.demo.service.IPedidoService;
import com.example.demo.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/store/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuariosControllerAPI {

    @Autowired
    IUsuarioService usuarioServ;
    @Autowired
    IPedidoService pedidoServ;
    @Autowired
    IDetallesPedido detallesPedidoServ;

    @PostMapping("/signup")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario user) {

        if (!usuarioServ.findUsuarioByNombreusuarioAndContrasena(user.getNombreusuario(), user.getContrasena())) {
            System.out.println("Usuario NO encontrado");
            return new ResponseEntity<Usuario>(user , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<List<DetallesPedido>> loginUsuario(@RequestBody Usuario user) {

        if (usuarioServ.findUsuarioByNombreusuarioAndContrasena(user.getNombreusuario(), user.getContrasena())) {

            Usuario u = usuarioServ.getUsuarioByNombreusuarioAndContrasena(user.getNombreusuario(), user.getContrasena());
            
            return new ResponseEntity<>(
                detallesPedidoServ.obtenerDetallesPedidoByPedido(
                    pedidoServ.obtenerPedidoByUsuarioAndEstado(u , 1)
                ) , HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
