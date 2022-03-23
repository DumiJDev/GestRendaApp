package ao.dumijdev.gestreandaapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RedirectController {

    @GetMapping
    public String index(){
        final String redirect = "redirect:/usuario";
        return "index";
    }
}
