package com.scierie_application.scierie.monnaie;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface MonnaieRepository extends JpaRepository<Monnaie , Long> {

    Optional<Monnaie> findByNom(String nom);
}
