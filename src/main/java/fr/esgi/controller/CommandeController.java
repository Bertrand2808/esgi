package fr.esgi.controller;

import fr.esgi.business.Sachet;
import fr.esgi.business.TypeDeGraine;
import fr.esgi.repository.SachetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommandeController {

    private final SachetRepository sachetRepository;

    public CommandeController(SachetRepository sachetRepository) {
        this.sachetRepository = sachetRepository;
    }

    @GetMapping("/commande")
    public String getCommande(Model model) {
        List<Sachet> sachets = sachetRepository.findAll();
        model.addAttribute("sachets", sachets);
        return "commande";
    }
}