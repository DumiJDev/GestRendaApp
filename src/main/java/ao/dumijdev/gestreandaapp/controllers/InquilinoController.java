package ao.dumijdev.gestreandaapp.controllers;

import ao.dumijdev.gestreandaapp.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/inquilino")
public class InquilinoController {

    private static Map<Long, Inquilino> inquilinos;
    private Long id;

    public InquilinoController() {
        InquilinoController.inquilinos = new HashMap<>();
    }

    @GetMapping
    public String index(){
        return "redirect:/inquilino/lista";
    }

    @GetMapping("/lista")
    public ModelAndView lista(){
        return new ModelAndView("inquilino/lista").
                addObject("list", inquilinos.values());
    }

    @GetMapping("prop={ID}?")
    public String propResInq(@PathVariable Long ID){

        id = ID;

        return "redirect:/inquilino/novo";
    }

    @GetMapping("/novo")
    public ModelAndView novoInquilinoGet(){
        return new ModelAndView("inquilino/novo").
                addObject("inquilino", new Inquilino(ResidenciaController.getResidencias().get(id))).
                addObject("Sexo", Sexo.values());
    }

    @PostMapping("/novo")
    public String novoInquilinoPost(Inquilino inquilino){

        Inquilino i = new Inquilino();
        i.setTelefone(i.getTelefone());
        i.setSobrenome(inquilino.getSobrenome());
        i.setSexo(inquilino.getSexo());
        i.setEntrada(inquilino.getEntrada());

        ResidenciaController.getResidencias().get(id).setInquilino(i);
        ResidenciaController.getResidencias().get(id).setOcupante(Ocupante.INQUILINO);

        inquilinos.put(i.getID(), i);

        return "redirect:/residencia/" + id;
    }

    public static Map<Long, Inquilino> getInquilinos() {
        return inquilinos;
    }
}
