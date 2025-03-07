package com.scierie_application.scierie.contrat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@EnableJpaRepositories
public interface ContratRepository extends JpaRepository<Contrat , Long> {

    @Query(value = "select * from contrat where code_contrat= :code" , nativeQuery = true)
    public Optional<Contrat> findByCode(@Param("code") String code);
}
