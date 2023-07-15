package com.example.personne.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.personne.entity.Personne;
import com.example.personne.entity.PersonneAvecAge;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private List<Personne> personnes = new ArrayList();

    @PostMapping("/create/personne")
    public ResponseEntity<String> sauvegarderPersonne(@RequestBody Personne personne) {
        // Calculer l'âge actuel de la personne
        int age = Period.between(personne.getDateNaissance().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();

        if (age >= 150) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La personne est trop âgée pour être enregistrée.");
        }

        personnes.add(personne);
        return ResponseEntity.status(HttpStatus.CREATED).body("Personne enregistrée avec succès.");
    }

    @GetMapping("/get/personnes")
    public ResponseEntity<List<PersonneAvecAge>> listerPersonnes() {
        // Créer une liste de personnes avec leur âge actuel
        List<PersonneAvecAge> personnesAvecAge = new ArrayList();
        PersonneAvecAge personneAvecAge=null;
        for (Personne personne : personnes) {
            int age = Period.between(personne.getDateNaissance().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
            personneAvecAge = new PersonneAvecAge(personne, age);
            personnesAvecAge.add(personneAvecAge);
        }

        // Trier les personnes par ordre alphabétique
        
        personnesAvecAge.sort(Comparator.comparing(PersonneAvecAge::getNom, String.CASE_INSENSITIVE_ORDER));


        return ResponseEntity.ok(personnesAvecAge);
    }
}