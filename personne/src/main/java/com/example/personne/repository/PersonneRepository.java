package com.example.personne.repository;



import org.springframework.data.jpa.repository.*;

import com.example.personne.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
