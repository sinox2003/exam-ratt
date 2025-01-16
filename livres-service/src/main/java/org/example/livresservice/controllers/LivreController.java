package org.example.livresservice.controllers;

import org.example.livresservice.entities.Livre;
import org.example.livresservice.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {


    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping
    public ResponseEntity<List<Livre>> getAllLivres() {
        return ResponseEntity.ok(livreService.getAllLivres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livre> createLivre(@RequestBody Livre livre) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livreService.saveLivre(livre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable Long id, @RequestBody Livre livre) {
        return livreService.getLivreById(id)
                .map(existingLivre -> {
                    livre.setId(id);
                    return ResponseEntity.ok(livreService.saveLivre(livre));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        if (livreService.getLivreById(id).isPresent()) {
            livreService.deleteLivre(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/auteur/{auteur}")
    public ResponseEntity<List<Livre>> getLivresByAuteur(@PathVariable String auteur) {
        return ResponseEntity.ok(livreService.getLivresByAuteur(auteur));
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Livre> getLivreByIsbn(@PathVariable String isbn) {
        return livreService.getLivreByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/annee/{annee}")
    public ResponseEntity<List<Livre>> getLivresByAnnee(@PathVariable Integer annee) {
        return ResponseEntity.ok(livreService.getLivresByAnnee(annee));
    }
}