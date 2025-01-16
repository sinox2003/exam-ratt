package org.example.livresservice.controllers.repositories;

import org.example.livresservice.controllers.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivreRepository extends JpaRepository<Livre,Long> {

    List<Livre> findByAuteur(String auteur);
    Optional<Livre> findByIsbn(String isbn);
    List<Livre> findByAnneePublication(Integer annee);

}
