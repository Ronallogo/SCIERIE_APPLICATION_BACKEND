package com.scierie_application.scierie.essence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface EssenceRepository extends JpaRepository<Essence , Long> {

    Optional<Essence> findByLibelle(String nom);

    /**
     * Retrieves a list of Essence entities where the libelle contains the specified string.
     *
     * @param nom the string to search for within the libelle field of Essence entities
     * @return a list of Essence entities with libelle containing the specified string
     */
    List<Essence> findByLibelleContaining(String nom);


}
