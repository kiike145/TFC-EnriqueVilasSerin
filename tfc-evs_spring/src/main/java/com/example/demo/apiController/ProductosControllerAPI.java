package com.example.demo.apiController;

import com.example.demo.model.Producto;
import com.example.demo.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/store/prods")
public class ProductosControllerAPI {

    @Autowired
    IProductosService productosServ;

    @GetMapping("/")
    public ResponseEntity<List<Producto>> mostrarProductos() {
        return new ResponseEntity<>(productosServ.obtenerProductosActivos() , HttpStatus.OK);
    }

}
