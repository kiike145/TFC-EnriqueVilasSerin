package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepo;

    @Override
    public Boolean crearUsuario(Usuario u) {

        if (usuarioRepo.findByNombreusuarioAndContrasena(u.getNombreusuario() , u.getContrasena()) == null) {
            u.setActivo(true);
            usuarioRepo.save(u);
            return true;
        }
        return false;
    }

    @Override
    public void eliminarUsuarioById(Integer id) {
        Optional<Usuario> o = usuarioRepo.findById(id);

        if (o.isPresent()) {
            o.get().setActivo(false);
            usuarioRepo.save(o.get());
        }
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        Optional<Usuario> o = usuarioRepo.findById(id);

        if (o.isPresent()) {
            return o.get();
        }
        return null;
    }

	@Override
	public void habilitarUsuarioById(Integer id) {
        Optional<Usuario> o = usuarioRepo.findById(id);

        if (o.isPresent()) {
            o.get().setActivo(true);
            usuarioRepo.save(o.get());
		}
	}

    @Override
    public boolean findUsuarioByNombreusuarioAndContrasena(String nombreusuario, String contrasena) {

        if (usuarioRepo.findByNombreusuarioAndContrasena(nombreusuario , contrasena) == null) {
            // En caso de que sea nulo, no existe ningun registro con esos datos
            return false;
        }
        return true;
    }

    @Override
    public Usuario getUsuarioByNombreusuarioAndContrasena(String nombreusuario, String contrasena) {
        return usuarioRepo.findByNombreusuarioAndContrasena(nombreusuario , contrasena);
    }
}
