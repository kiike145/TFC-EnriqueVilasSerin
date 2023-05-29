package com.example.demo.apiController;

import com.example.demo.model.Producto;
import com.example.demo.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/store/prods")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductosControllerAPI {

    @Autowired
    IProductosService productosServ;

    @GetMapping("/")
    public ResponseEntity<List<Producto>> mostrarProductos() {
        return new ResponseEntity<>(productosServ.obtenerProductosActivos() , HttpStatus.OK);
    }

    @GetMapping("/destacados")
    public ResponseEntity<List<Producto>> mostrarProductosDestacados() {
        return new ResponseEntity<>(productosServ.obtenerProductosDestacados() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> mostrarProductoById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(productosServ.obtenerProductoById(id) , HttpStatus.OK);
    }
}
