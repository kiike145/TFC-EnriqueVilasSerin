package com.example.demo.service;

import com.example.demo.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    void crearUsuario(Usuario u);
    void eliminarUsuarioById(Integer id);
    List<Usuario> obtenerUsuarios();
    Usuario obtenerUsuarioById(Integer id);
	void habilitarUsuarioById(Integer id);
}
