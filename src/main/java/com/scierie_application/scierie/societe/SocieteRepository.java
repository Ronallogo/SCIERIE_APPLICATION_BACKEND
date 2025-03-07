package com.scierie_application.scierie.societe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SocieteRepository extends JpaRepository<Societe , Long> {

}
