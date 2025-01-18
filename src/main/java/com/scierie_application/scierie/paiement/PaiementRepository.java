package com.scierie_application.scierie.paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface PaiementRepository extends JpaRepository<Paiement , Long> {
}
