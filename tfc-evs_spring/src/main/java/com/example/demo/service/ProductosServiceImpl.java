package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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
		
		List<Producto> productos = new LinkedList<>();
		
		for (Producto p : productosRepo.findByActivo(true)) {
			if (p.getCantidad() > 1) {
				productos.add(p);
			}
		}
		
		return productos;
	}

	@Override
	public void habilitarProductoById(Integer id) {
		Optional<Producto> p = productosRepo.findById(id);

		if (p.isPresent()) {
			
			p.get().setActivo(true);
			productosRepo.save(p.get());
		}
	}

	@Override
	public void actualizarProdcuto(Producto p) {
		productosRepo.save(p);
	}
}
