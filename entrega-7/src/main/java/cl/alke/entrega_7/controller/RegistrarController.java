package cl.alke.entrega_7.controller;

import cl.alke.entrega_7.model.Usuario;
import cl.alke.entrega_7.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrarController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/registrar")
    public String registrar() {
        return "registrar";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        System.out.println(usuario);
        usuarioService.save(usuario);
        model.addAttribute("usuario", usuario);
        return "inicio";
    }

}
