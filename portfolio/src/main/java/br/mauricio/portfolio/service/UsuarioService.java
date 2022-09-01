package br.mauricio.portfolio.service;

import br.mauricio.portfolio.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> findAll();
    public Optional<Usuario> findById(long id);
    public Usuario cadastrar(String nome, String email, String senha);
    public Optional<Usuario> login(String email, String senha);
    public Usuario update(Usuario updateUsuario, long id);
    public void deleteById(long id);
}
