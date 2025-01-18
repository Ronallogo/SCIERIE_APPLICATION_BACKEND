package com.scierie_application.scierie.essence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface EssenceRepository extends JpaRepository<Essence , Long> {
}
