package br.mauricio.portfolio.controller;

import br.mauricio.portfolio.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PgController {

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/usuario/cadastro")
    public String getCadastro(Model model) {
        model.addAttribute("CadastraUsuario", new Usuario());
        return "usuario/cadastro";
    }

    @GetMapping("/usuario/login")
    public String getLogin(Model model){
        model.addAttribute("LoginUsuario", new Usuario());
        return "usuario/login";
    }
}
