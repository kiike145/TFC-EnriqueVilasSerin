package com.example.demo.service;

import com.example.demo.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario crearUsuario(Usuario u);
    void eliminarUsuarioById(Integer id);
    List<Usuario> getUsuarios();
    Usuario getUsuarioById(Integer id);
	void habilitarUsuarioById(Integer id);
    boolean findUsuarioByNombreusuarioAndContrasena(String nombreusuario, String contrasena);
    Usuario getUsuarioByNombreusuarioAndContrasena(String nombreusuario, String contrasena);
}
