package com.scierie_application.scierie.societe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface RepositorySociete extends JpaRepository<Societe , Long> {
}
