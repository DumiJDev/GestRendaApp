package ao.dumijdev.gestreandaapp.controllers;

import ao.dumijdev.gestreandaapp.models.Proprietario;
import ao.dumijdev.gestreandaapp.models.Residencia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/residencia")
public class ResidenciaController {

    private static Map<Long, Residencia> residencias;
    Long ID;

    public ResidenciaController() {
        residencias = new HashMap<>();
        ID = 0L;
    }

    @GetMapping
    public String index(){
        return "redirect:/residencia/lista";
    }

    @GetMapping("/lista")
    public ModelAndView lista(){

        for (Proprietario p: ProprietarioController.getProprietarios().values()) {
            for (Residencia r: p.getResidencias()) {
                residencias.put(r.getID(), r);
            }
        }

        return new ModelAndView("residencia/lista").
                addObject("list", residencias.values());
    }

    @GetMapping("/residencia-{ID}")
    public ModelAndView residencia(@PathVariable Long ID){
        return new ModelAndView("residencia/detalhes").
                addObject("residencia", residencias.get(ID));
    }

    @GetMapping("/novo")
    public ModelAndView novaResidenciaGet(){
        return new ModelAndView("residencia/novo").
                addObject("residencia", new Residencia());
    }

    @PostMapping("/novo")
    public String novaResidenciaPost(Residencia residencia){

        Residencia res = new Residencia();
        res.setProprietario(ProprietarioController.getProprietarios().get(ID));
        res.setBairro(residencia.getBairro());
        res.setMunicipio(residencia.getMunicipio());
        res.setNumeroCasa(residencia.getNumeroCasa());
        res.setRua(residencia.getRua());

        ProprietarioController.getProprietarios().get(ID).getResidencias().add(res);

        return "redirect:/residencia/lista";
    }

    @GetMapping("/{ID}")
    public String propRes(@PathVariable Long ID) {
        this.ID = ID;
        return "redirect:/residencia/novo";
    }

    @GetMapping("/Apg-{ID}")
    public String propResApg(@PathVariable Long ID) {
        this.ID = ID;
        return "redirect:/residencia/novo";
    }

    public static Map<Long, Residencia> getResidencias() {
        return residencias;
    }
}
