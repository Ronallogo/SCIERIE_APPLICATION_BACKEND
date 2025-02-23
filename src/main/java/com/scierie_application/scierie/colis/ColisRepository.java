package com.scierie_application.scierie.colis;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ColisRepository  extends JpaRepository<Colis , Long> {
}
