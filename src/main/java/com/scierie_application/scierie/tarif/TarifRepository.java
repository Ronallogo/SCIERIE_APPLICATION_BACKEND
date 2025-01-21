package com.scierie_application.scierie.tarif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface TarifRepository extends JpaRepository<Tarif , Long> {
}
