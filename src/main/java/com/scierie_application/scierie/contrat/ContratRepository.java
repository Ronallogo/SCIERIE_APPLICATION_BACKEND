package com.scierie_application.scierie.contrat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ContratRepository extends JpaRepository<Contrat , Long> {
}
