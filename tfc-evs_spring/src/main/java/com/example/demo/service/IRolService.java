package com.example.demo.service;

import com.example.demo.model.Rol;
import java.util.List;


public interface IRolService {

    void crearRol(Rol r);
    void eliminarRolById(Integer id);
    List<Rol> obtenerRol();
    Rol obtenerRolById(Integer id);


}
