package com.scierie_application.scierie.pays;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface PaysRepository extends JpaRepository<Pays , Long> {
}
