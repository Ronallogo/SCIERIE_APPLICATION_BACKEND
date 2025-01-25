package com.scierie_application.scierie.grume;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
 

@EnableJpaRepositories
public interface GrumeRepository  extends JpaRepository<Grume,Long>{
    @Query(value = "select g from grume g where code_lots = :nom" , nativeQuery = true)
    Optional<Grume> findByCodeLots(@Param("nom") String nom);

}
