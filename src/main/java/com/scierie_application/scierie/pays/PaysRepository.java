package com.scierie_application.scierie.pays;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


@EnableJpaRepositories
public interface PaysRepository extends JpaRepository<Pays , Long> {

    @Query(value="select * from pays where nom_pays= :nom" , nativeQuery = true)
    Optional<Pays> findByNom(@Param("nom")String nom);
}
