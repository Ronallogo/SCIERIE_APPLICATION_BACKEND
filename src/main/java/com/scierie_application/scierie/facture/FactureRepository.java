package com.scierie_application.scierie.facture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface FactureRepository extends JpaRepository<Facture , Long> {
}
