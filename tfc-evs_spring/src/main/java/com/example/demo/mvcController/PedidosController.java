package com.example.demo.mvcController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Pedido;
import com.example.demo.service.IPedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

	@Autowired
	IPedidoService pedidosServ;

	@GetMapping("/")
	public String homePedidos(Model model) {
		model.addAttribute("listaPedidos", pedidosServ.obtenerPedidos());
		return "pedidos/home";
	}

	@GetMapping("/edit/{id}")
	public String actualizarPedido(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("pedido", pedidosServ.obtenerPedidoById(id));
		return "/pedidos/form";
	}
	
	@GetMapping("/activate/{id}")
	public String habilitarPedido(@PathVariable("id") Integer id) {
		pedidosServ.habilitarPedidoById(id);
		return "redirect:/pedidos/";
	}

	@GetMapping("/delete/{id}")
	public String borrarPedido(@PathVariable("id") Integer id, RedirectAttributes attributes) {
		pedidosServ.borrarPedidoById(id);
		attributes.addFlashAttribute("msg", "Registro eliminado correctamente");
		return "redirect:/pedidos/";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Pedido p, Model model) {
		return "/pedidos/form";
	}

	@PostMapping("/save")
	public String guardarPedido(Pedido p, BindingResult result, RedirectAttributes attributes) {
		pedidosServ.guardarPedido(p);
		attributes.addFlashAttribute("msg", "Registro realizado correctamente");
		return "redirect:/pedidos/";
	}
}
