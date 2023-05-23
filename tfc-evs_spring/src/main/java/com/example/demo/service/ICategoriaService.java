package com.example.demo.service;

import com.example.demo.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    void crearCategoria(Categoria c);
    void borrarCategoriaById(Integer id);
    List<Categoria> obtenerCategorias();
    Categoria obtenerCategoriaById(Integer id);


}
