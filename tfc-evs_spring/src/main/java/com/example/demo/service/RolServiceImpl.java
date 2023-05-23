package com.example.demo.service;

import com.example.demo.model.Rol;
import com.example.demo.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    RolRepository rolRepo;

    @Override
    public void crearRol(Rol r) {
        rolRepo.save(r);
    }

    @Override
    public void eliminarRolById(Integer id) {
        rolRepo.deleteById(id);
    }

    @Override
    public List<Rol> obtenerRol() {
        return rolRepo.findAll();
    }

    @Override
    public Rol obtenerRolById(Integer id) {
        Optional<Rol> o = rolRepo.findById(id);

        if (o.isPresent()) {
            return o.get();
        }
        
        return null;
    }
}
