package com.example.demo.repository;

import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombreusuarioAndContrasena(String username , String password);
    List<Usuario> findByActivo(Boolean activo);
}
