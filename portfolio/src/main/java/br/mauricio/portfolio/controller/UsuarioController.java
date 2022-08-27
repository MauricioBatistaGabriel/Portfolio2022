package br.mauricio.portfolio.controller;

import br.mauricio.portfolio.model.Usuario;
import br.mauricio.portfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listarUsuarios")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/listarUsuariopId/{id}")
    public Optional<Usuario> findById(@PathVariable long id){
        return usuarioService.findById(id);
    }

    @PostMapping("/cadastrarUsuario")
    public Usuario create(@RequestBody Usuario newUsuario){
        return usuarioService.create(newUsuario);
    }

    @PutMapping("/editarUsuario/{id}")
    public Usuario update(@RequestBody Usuario updateUsuario, @PathVariable long id){
        return usuarioService.update(updateUsuario, id);
    }

    @DeleteMapping("deletarUsuariopId/{id}")
    public void deleteById(@PathVariable long id){
        usuarioService.deleteById(id);
    }
}
