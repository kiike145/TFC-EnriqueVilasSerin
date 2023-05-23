package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements IProductosService {

	@Autowired
	ProductoRepository productosRepo;

	@Override
	public void guardarProducto(Producto p) {
		p.setActivo(true);
		productosRepo.save(p);
	}

	@Override
	public void borrarProductoById(Integer id) {
		Optional<Producto> p = productosRepo.findById(id);

		if (p.isPresent()) {
			p.get().setActivo(false);
			productosRepo.save(p.get());
		}
	}

	@Override
	public Producto obtenerProductoById(Integer id) {

		Optional<Producto> p = productosRepo.findById(id);

		if (p.isPresent()) {
			return p.get();
		}
		return null;
	}

	@Override
	public List<Producto> obtenerProductos() {
		return productosRepo.findAll();
	}

	@Override
	public List<Producto> obtenerProductosDestacados() {
		return productosRepo.findByDestacado(true);
	}

	@Override
	public List<Producto> obtenerProductosActivos() {
		return productosRepo.findByActivo(true);
	}

	@Override
	public void habilitarProductoById(Integer id) {
		Optional<Producto> p = productosRepo.findById(id);

		if (p.isPresent()) {
			
			p.get().setActivo(true);
			productosRepo.save(p.get());
		}
	}
}
