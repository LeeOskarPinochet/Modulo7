package cl.alke.entrega_7.service;

import cl.alke.entrega_7.model.Transferencia;
import cl.alke.entrega_7.model.Usuario;
import cl.alke.entrega_7.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository repo;

    public Transferencia save(Transferencia transferencia) {
        return repo.save(transferencia);
    }

    public List<Transferencia> getAll() {
        return repo.findAll();
    }
    

}
