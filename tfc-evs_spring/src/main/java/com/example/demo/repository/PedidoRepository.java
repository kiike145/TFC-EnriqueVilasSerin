package com.example.demo.repository;

import com.example.demo.model.Pedido;
import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByActivo(Boolean activo);
    Pedido findByUsuarioAndEstado(Usuario u , Integer estado);
}
