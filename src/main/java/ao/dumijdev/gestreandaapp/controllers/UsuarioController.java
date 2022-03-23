package ao.dumijdev.gestreandaapp.controllers;

import ao.dumijdev.gestreandaapp.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private static Usuario usuario;

    @GetMapping
    public String usuario(){
        return "usuario/login";
    }

    @GetMapping("/login")
    public String login(){
        return "";
    }
}
