package cl.alke.entrega_7.controller;

import cl.alke.entrega_7.model.*;
import cl.alke.entrega_7.service.MovimientoService;
import cl.alke.entrega_7.service.TransferenciaService;
import cl.alke.entrega_7.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

@Controller
public class movimientoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TransferenciaService transferenciaService;

    @Autowired
    private MovimientoService movimientoService;


    @PostMapping("/movimiento")
    public String movimiento(@ModelAttribute("user") User user, Model model){
        Usuario usuario = usuarioService.getOne(user.getUsuarioId());
        model.addAttribute("usuario", usuario);
        System.out.println("Entro al deposito");
        System.out.println(user);
        return "depositar";
    }

    @PostMapping("/movimiento/depositar")
    public String depositar(@ModelAttribute("deposito") Deposito deposito, Model model){
        boolean resultado = movimientoService.registrarMovimiento(2, deposito.getUsuarioId(),
                deposito.getMonto());
        model.addAttribute("usuario", usuarioService.getOne(deposito.getUsuarioId()));
        System.out.println(resultado);
        if(resultado) {
            model.addAttribute("resultado", "Deposito exitoso");
        } else {
            model.addAttribute("resultado", "Deposito fallido");
        }
    return "home";
    }

    @PostMapping("/movimiento/retirar")
    public String retirar(@ModelAttribute("deposito") Deposito deposito, Model model){
        Usuario usuario = usuarioService.getOne(deposito.getUsuarioId());
        model.addAttribute("usuario", usuario);
        System.out.println("Entro al retiro");
        return "retirar";
    }

    @PostMapping("/movimiento/retirarMonto")
    public String retirarMonto(@ModelAttribute("deposito") Deposito deposito, Model model){
        boolean resultado = movimientoService.registrarMovimiento(deposito.getUsuarioId(), 2,
                deposito.getMonto());
        model.addAttribute("usuario", usuarioService.getOne(deposito.getUsuarioId()));
        System.out.println(resultado);
        if(resultado) {
            model.addAttribute("resultado", "Retiro exitoso");
        } else {
            model.addAttribute("resultado", "Retiro fallido");
        }
        return "home";
    }

    @PostMapping("/movimiento/transferencia")
    public String transferir(@ModelAttribute("deposito") Deposito deposito, Model model) {
        Usuario usuario = usuarioService.getOne(deposito.getUsuarioId());
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuario", usuario);
        model.addAttribute("destinatarios", usuarios);
        System.out.println("Entro al transferir");
        return "transferir";
    }

    @PostMapping("/movimiento/transferenciaExec")
    public String retirarMonto(@ModelAttribute("transferencia") TransferenciaExec transferencia, Model model){
        System.out.println("Entro al transferenciaExec");
        System.out.println(transferencia);
        boolean resultado = movimientoService.registrarMovimiento(transferencia.getUsuarioId(),
                transferencia.getDestinatarioId(), transferencia.getMonto());
        model.addAttribute("usuario", usuarioService.getOne(transferencia.getUsuarioId()));
        System.out.println(resultado);
        if(resultado) {
            model.addAttribute("resultado", "Transferencia exitosa");
        } else {
            model.addAttribute("resultado", "Transferencia fallida");
        }
        return "home";
    }


}
