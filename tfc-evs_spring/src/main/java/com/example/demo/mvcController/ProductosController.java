package com.example.demo.mvcController;

import com.example.demo.model.Producto;
import com.example.demo.service.ICategoriaService;
import com.example.demo.service.IProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	IProductosService productosServ;
	@Autowired
	ICategoriaService categoriaServ;

	@GetMapping("/")
	public String homeProductos(Model model) {
		model.addAttribute("listaProds", productosServ.obtenerProductos());
		return "productos/home";
	}

	@GetMapping("/edit/{id}")
	public String actualizarProducto(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("listaCategorias", categoriaServ.obtenerCategorias());
		model.addAttribute("producto", productosServ.obtenerProductoById(id));
		return "/productos/form";
	}
	
	@GetMapping("/activate/{id}")
	public String habilitarProducto(@PathVariable("id") Integer id) {
		productosServ.habilitarProductoById(id);
		return "redirect:/productos/";
	}

	@GetMapping("/delete/{id}")
	public String borrarProducto(@PathVariable("id") Integer id, RedirectAttributes attributes) {
		productosServ.borrarProductoById(id);
		attributes.addFlashAttribute("msg", "Registro eliminado correctamente");
		return "redirect:/productos/";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Producto p, Model model) {
		model.addAttribute("listaCategorias", categoriaServ.obtenerCategorias());
		return "/productos/form";
	}

	@PostMapping("/save")
	public String guardarProducto(Producto p, BindingResult result, RedirectAttributes attributes) {
		productosServ.guardarProducto(p);
		attributes.addFlashAttribute("msg", "Registro realizado correctamente");
		return "redirect:/productos/";
	}
}
