package br.mauricio.portfolio.controller;

import br.mauricio.portfolio.model.Usuario;
import br.mauricio.portfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/listarpId/{id}")
    public Optional<Usuario> findById(@PathVariable long id){
        return usuarioService.findById(id);
    }

    @PutMapping("/editar/{id}")
    public Usuario update(@RequestBody Usuario updateUsuario, @PathVariable long id){
        return usuarioService.update(updateUsuario, id);
    }

    @DeleteMapping("/deletarpId/{id}")
    public void deleteById(@PathVariable long id){
        usuarioService.deleteById(id);
    }

    //Métodos da página
    @PostMapping("/cadastro")
    public String cadastro(@ModelAttribute Usuario usuario){
        usuarioService.cadastrar(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        System.out.println("USUARIO CADASTRADO: " + usuario.toString());
        return "usuario/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuario){
        usuarioService.login(usuario.getEmail(), usuario.getSenha());
        return "paginaInicial";
    }
}
