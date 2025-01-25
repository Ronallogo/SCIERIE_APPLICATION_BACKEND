package com.scierie_application.scierie.fournisseur;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}
