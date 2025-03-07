package com.scierie_application.scierie.monnaie;

 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;


@EnableJpaRepositories
public interface MonnaieRepository extends JpaRepository<Monnaie , Long> {



    @Query("SELECT m FROM Monnaie m WHERE m.nom_monnaie = :nom")      
    Optional<Monnaie> findByNom(@Param("nom") String nom);
}
