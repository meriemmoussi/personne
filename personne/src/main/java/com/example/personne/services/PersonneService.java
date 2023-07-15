package com.example.personne.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personne.entity.Personne;
import com.example.personne.repository.PersonneRepository;

import java.util.List;

@Service
public class PersonneService {
    private final PersonneRepository personneRepository;

    @Autowired
    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public void sauvegarderPersonne(Personne personne) {
        personneRepository.save(personne);
    }

    public List<Personne> listerPersonnes() {
        return personneRepository.findAll();
    }
}
