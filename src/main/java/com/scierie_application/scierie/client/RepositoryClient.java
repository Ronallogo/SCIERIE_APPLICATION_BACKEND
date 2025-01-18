package com.scierie_application.scierie.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface RepositoryClient extends JpaRepository<Client , Long> {
}
