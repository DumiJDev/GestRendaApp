package ao.dumijdev.gestreandaapp.controllers;

import ao.dumijdev.gestreandaapp.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping(value = "/proprietario")
public class ProprietarioController {

    private static Map<Long, Proprietario> proprietarios;

    public ProprietarioController() {
        proprietarios = new HashMap<>();

        proprietarios.put(1L,
                new Proprietario("Dumildes",
                        "Paulo",
                        "937143150",
                        Sexo.Masculino,
                        new Residencia("Luanda", "Prenda", "ff", "90", Ocupante.DONO)));

        proprietarios.put(2L,
                new Proprietario(
                        "António",
                        "Fernando",
                        "937143153",
                        Sexo.Masculino,
                        new Residencia("Cacuaco", "Belo Monte", "iro", "09", Ocupante.DONO)));

        proprietarios.put(3L,
                new Proprietario(
                        "Alves",
                        "Zulu",
                        "937143157",
                        Sexo.Masculino,
                        new Residencia("Belas", "Belas", "pooo", "08", Ocupante.DONO)));

    }

    @GetMapping
    public String index() {
        return "redirect:/proprietario/lista";
    }

    @GetMapping("/lista")
    public ModelAndView lista() {
        return new ModelAndView("proprietario/lista").
                addObject("list", proprietarios.values()).
                addObject("Masculino", Sexo.Masculino);
    }

    @GetMapping("/novo")
    public ModelAndView novoProprietarioGet() {
        return new ModelAndView("proprietario/novo").
                addObject("proprietario", new Proprietario()).
                addObject("sexo", Sexo.values());
    }

    @PostMapping("/novo")
    public String novoProprietarioPost(Proprietario proprietario) {
        Proprietario proprietario1;
        proprietario1 = new Proprietario(proprietario.getNome(), proprietario.getSobrenome(), proprietario.getTelefone(),
                proprietario.getSexo(), proprietario.getResidencia());

        System.out.println(proprietario.getSexo());

        proprietarios.put(proprietario1.getID(), proprietario1);

        return "redirect:/proprietario/lista";
    }

    @GetMapping("/prop-{ID}")
    public ModelAndView proprietario(@PathVariable Long ID) {
        return new ModelAndView("proprietario/detalhes").
                addObject("proprietario", proprietarios.get(ID)).
                addObject("residencia", new Residencia());
    }

    @PostMapping("/prop-{ID}")
    public String novaPropriedade(@PathVariable Long ID, Residencia residencia) {
        final Proprietario proprietario;
        proprietario = proprietarios.get(ID);
        proprietario.getResidencias().
                add(new Residencia(
                        residencia.getMunicipio(),
                        residencia.getBairro(),
                        residencia.getRua(),
                        residencia.getNumeroCasa(),
                        Ocupante.DONO
                        ));
        proprietarios.remove(ID);
        proprietarios.put(ID, proprietario);

        return "redirect:/proprietario/prop-" + ID;
    }

    public static Map<Long, Proprietario> getProprietarios() {
        return proprietarios;
    }
}
