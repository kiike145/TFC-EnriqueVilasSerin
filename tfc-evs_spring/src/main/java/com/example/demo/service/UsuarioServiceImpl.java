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
    public void crearUsuario(Usuario u) {
        u.setActivo(true);
        usuarioRepo.save(u);
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
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario obtenerUsuarioById(Integer id) {
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
}
