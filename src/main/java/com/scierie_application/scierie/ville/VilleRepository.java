package com.scierie_application.scierie.ville;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface VilleRepository extends JpaRepository<Ville , Long> {
    @Query("SELECT v FROM Ville v WHERE v.nom_ville = :nom")    
    Optional<Ville> findByNom_Ville(String nom);
}
