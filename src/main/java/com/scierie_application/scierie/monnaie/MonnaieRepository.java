package com.scierie_application.scierie.monnaie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface MonnaieRepository extends JpaRepository<Monnaie , Long> {
}
