package br.mauricio.portfolio.service;

import br.mauricio.portfolio.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> findAll();
    public Optional<Usuario> findById(long id);
    public Usuario create(Usuario newUsuario);
    public Usuario update(Usuario updateUsuario, long id);
    public void deleteById(long id);
}
