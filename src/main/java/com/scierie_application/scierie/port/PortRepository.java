package com.scierie_application.scierie.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface PortRepository extends JpaRepository<Port , Long> {
}
