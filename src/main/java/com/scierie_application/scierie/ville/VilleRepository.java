package com.scierie_application.scierie.ville;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;


@EnableJpaRepositories
public interface VilleRepository extends JpaRepository<Ville , Long> {
    @Query(value="SELECT * FROM ville v WHERE v.nom_ville LIKE CONCAT('%', :nom, '%')" , nativeQuery = true)    
    Optional<Ville> findByNom_Ville(@Param("nom") String nom);
}
