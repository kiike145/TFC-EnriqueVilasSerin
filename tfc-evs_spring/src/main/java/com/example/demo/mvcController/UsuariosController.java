package com.example.demo.mvcController;

import com.example.demo.model.Usuario;
import com.example.demo.service.IRolService;
import com.example.demo.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UsuariosController {

    @Autowired
    IUsuarioService usuarioServ;
    @Autowired
    IRolService rolServ;

    @GetMapping("/")
    public String homeUsuarios(Model model) {
        model.addAttribute("listaUsers" , usuarioServ.obtenerUsuarios());
        return "usuarios/home";
    }


    @GetMapping("/edit/{id}")
    public String actualizarUsuario(@PathVariable("id") Integer id , Model model) {
        model.addAttribute("listaRoles", rolServ.obtenerRol());
        model.addAttribute("usuario", usuarioServ.obtenerUsuarioById(id));
        return "/usuarios/form";
    }

    @GetMapping("/delete/{id}")
    public String borrarUsuario(@PathVariable("id") Integer id , RedirectAttributes attributes) {
        usuarioServ.eliminarUsuarioById(id);
        attributes.addFlashAttribute("msg", "Registro eliminado correctamente");
        return "redirect:/usuarios/";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Usuario u , Model model) {
        model.addAttribute("listaRoles", rolServ.obtenerRol());
        return "/usuarios/form";
    }

    @PostMapping("/save")
    public String guardarUsuario(Usuario u, BindingResult result , RedirectAttributes attributes) {
        usuarioServ.crearUsuario(u);
        attributes.addFlashAttribute("msg", "Registro realizado correctamente");
        return "redirect:/Usuarios/";
    }

}
