package org.example.utilisateursservice.services;

import org.example.utilisateursservice.Entities.Utilisateur;
import org.example.utilisateursservice.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService  {


    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurRepository.findAllUtilisateurs();
    }

    public Optional<Utilisateur> findUtilisateurById(Long id) {
        return utilisateurRepository.findUtilisateurById(id);
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.saveUtilisateur(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteUtilisateur(id);
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.updateUtilisateur(utilisateur);
    }
}