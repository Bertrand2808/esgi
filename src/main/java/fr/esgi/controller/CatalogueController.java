package fr.esgi.controller;

import fr.esgi.business.TypeDeGraine;
import fr.esgi.service.TypeDeGraineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CatalogueController {

    private final TypeDeGraineService typeDeGraineService;

    public CatalogueController(TypeDeGraineService typeDeGraineService) {
        this.typeDeGraineService = typeDeGraineService;
    }

    @GetMapping("/catalogue")
    public String getCatalogue(@RequestParam(required = false) String famille, Model model) {
        List<TypeDeGraine> graines = typeDeGraineService.getGrainesByFamille(famille);
        model.addAttribute("graines", graines);
        return "catalogue";
    }
}