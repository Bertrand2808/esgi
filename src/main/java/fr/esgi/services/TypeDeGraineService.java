package fr.esgi.service;

import fr.esgi.business.TypeDeGraine;
import fr.esgi.repository.TypeDeGraineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeDeGraineService {

    private final TypeDeGraineRepository typeDeGraineRepository;

    public TypeDeGraineService(TypeDeGraineRepository typeDeGraineRepository) {
        this.typeDeGraineRepository = typeDeGraineRepository;
    }

    public List<TypeDeGraine> getGrainesByFamille(String famille) {
        if (famille == null || famille.isEmpty()) {
            return typeDeGraineRepository.findAll();
        } else {
            return typeDeGraineRepository.findByFamilleNom(famille);
        }
    }
}