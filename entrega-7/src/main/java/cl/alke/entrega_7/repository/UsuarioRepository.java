package cl.alke.entrega_7.repository;

import cl.alke.entrega_7.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
