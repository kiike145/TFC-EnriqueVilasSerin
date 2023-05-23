package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    CategoriaRepository categoriaRepo;

    @Override
    public void crearCategoria(Categoria c) {
        categoriaRepo.save(c);
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return categoriaRepo.findAll();
    }

    @Override
    public void borrarCategoriaById(Integer id) {
        categoriaRepo.deleteById(id);
    }

    @Override
    public Categoria obtenerCategoriaById(Integer id) {
        Optional<Categoria> o = categoriaRepo.findById(id);

        if (o.isPresent()) {
            return o.get();
        }

        return null;
    }
}
