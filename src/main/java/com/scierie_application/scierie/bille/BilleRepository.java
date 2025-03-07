package com.scierie_application.scierie.bille;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
public interface BilleRepository extends JpaRepository<Bille , Long> {
}
