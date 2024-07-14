package cl.alke.entrega_7.service;

import cl.alke.entrega_7.model.Usuario;
import cl.alke.entrega_7.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public void save(Usuario usuario) {
        repo.save(usuario);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }


    public Usuario getOne(int id) {
        return repo.findById(id).get();
    }

    public void update(Usuario usuario) {
        repo.save(usuario);
    }


    public List<Usuario> getAll() {
        return repo.findAll();
    }
}
