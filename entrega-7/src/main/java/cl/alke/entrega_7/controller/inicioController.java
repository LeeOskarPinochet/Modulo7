package cl.alke.entrega_7.controller;

import cl.alke.entrega_7.model.Transferencia;
import cl.alke.entrega_7.model.User;
import cl.alke.entrega_7.model.Usuario;
import cl.alke.entrega_7.service.TransferenciaService;
import cl.alke.entrega_7.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class inicioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TransferenciaService transferenciaService;


    @GetMapping("/")
    public String inicio(Model model){
        System.out.println(usuarioService.getAll());

        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);

        System.out.println(transferenciaService.getAll());
        return "inicio";
    }



    @PostMapping("/")
    public String ingresar(@ModelAttribute("user") User user, Model model) {
        System.out.println(user);
        Usuario usuario = usuarioService.getOne(user.getUsuarioId());
        model.addAttribute("usuario", usuario);
        System.out.println(usuario);
        return "home";
    }



}
