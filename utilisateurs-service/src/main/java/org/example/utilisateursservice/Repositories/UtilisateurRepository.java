package org.example.utilisateursservice.Repositories;

import org.example.utilisateursservice.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    List<Utilisateur> findAllUtilisateurs();
    Optional<Utilisateur> findUtilisateurById(Long id);
    Utilisateur saveUtilisateur(Utilisateur user);
    void deleteUtilisateur(Long id);
    Utilisateur updateUtilisateur(Utilisateur user);
}
