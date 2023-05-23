package com.example.demo.repository;

import com.example.demo.model.DetallesPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallesPedidoRepository extends JpaRepository<DetallesPedido, Integer> {
}
