package br.mauricio.portfolio.service;

import br.mauricio.portfolio.model.Usuario;
import br.mauricio.portfolio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario cadastrar(String nome, String email, String senha) {
        Usuario newUsuario = new Usuario();
        newUsuario.setNome(nome);
        newUsuario.setEmail(email);
        newUsuario.setSenha(senha);
        return usuarioRepository.save(newUsuario);
    }

    @Override
    public Optional<Usuario> login(String email, String senha){
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }

    @Override
    public Usuario update(Usuario updateUsuario, long id) {
        return usuarioRepository.findById(id)
        .map(u -> {
            usuarioRepository.save(updateUsuario);
            u.setNome(updateUsuario.getNome());
            u.setEmail(updateUsuario.getEmail());
            u.setSenha(updateUsuario.getSenha());
            return usuarioRepository.save(u);
        })
                .orElseGet(() -> {
                    return usuarioRepository.save(updateUsuario);
                });
    }

    @Override
    public void deleteById(long id) {
        usuarioRepository.deleteById(id);
    }
}
