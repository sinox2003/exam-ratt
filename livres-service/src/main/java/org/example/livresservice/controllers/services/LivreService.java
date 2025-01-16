package org.example.livresservice.controllers.services;

import org.example.livresservice.controllers.entities.Livre;
import org.example.livresservice.controllers.repositories.LivreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service
@Service
public class LivreService {


    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }

    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }

    public List<Livre> getLivresByAuteur(String auteur) {
        return livreRepository.findByAuteur(auteur);
    }

    public Optional<Livre> getLivreByIsbn(String isbn) {
        return livreRepository.findByIsbn(isbn);
    }

    public List<Livre> getLivresByAnnee(Integer annee) {
        return livreRepository.findByAnneePublication(annee);
    }
}