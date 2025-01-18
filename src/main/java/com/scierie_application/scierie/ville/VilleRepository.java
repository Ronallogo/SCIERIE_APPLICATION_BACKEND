package com.scierie_application.scierie.ville;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface VilleRepository extends JpaRepository<Ville , Long> {
}
