package cl.alke.entrega_7.repository;

import cl.alke.entrega_7.model.Transferencia;
import cl.alke.entrega_7.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {
}
