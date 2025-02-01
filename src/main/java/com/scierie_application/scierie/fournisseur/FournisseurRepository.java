package com.scierie_application.scierie.fournisseur;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {


    @Query(value="select avg(taxe_abbatage) as taxe_moy from fournisseur;" , nativeQuery = true)
    Float taxeMoyenneFournisseur();

}
