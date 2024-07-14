package cl.alke.entrega_7.service;

import cl.alke.entrega_7.model.Transferencia;
import cl.alke.entrega_7.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.Date;

@Service
public class MovimientoService {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TransferenciaService transferenciaService;

    @Transactional
    public boolean registrarMovimiento(int emisor, int receptor, int monto) {
        System.out.println("Entro a la transaccion de movimiento");
        Usuario usuarioEmisor = usuarioService.getOne(emisor);
        Usuario usuarioReceptor = usuarioService.getOne(receptor);
        System.out.println(usuarioEmisor);
        System.out.println(usuarioReceptor);

        if (usuarioEmisor == null || usuarioReceptor == null) {
            System.out.println("emisor invalido");
            return false;

        }

        if (usuarioEmisor.getSaldo() < monto) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        if (monto <= 0) {
            System.out.println("monto igual a 0");
            return false;
        }

        Transferencia transferencia = new Transferencia();
        transferencia.setEmisor(usuarioEmisor);
        transferencia.setReceptor(usuarioReceptor);
        transferencia.setMonto(monto);
        transferencia.setFecha(java.time.LocalDate.now().toString());
        transferenciaService.save(transferencia);

        usuarioEmisor.setSaldo(usuarioEmisor.getSaldo() - monto);
        usuarioReceptor.setSaldo(usuarioReceptor.getSaldo() + monto);

        usuarioService.update(usuarioEmisor);
        usuarioService.update(usuarioReceptor);


        return true;
    }
}
