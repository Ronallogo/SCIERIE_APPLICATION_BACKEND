package com.scierie_application.scierie.traitement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TraitementRepository  extends JpaRepository<Traitement , Long>{

}
