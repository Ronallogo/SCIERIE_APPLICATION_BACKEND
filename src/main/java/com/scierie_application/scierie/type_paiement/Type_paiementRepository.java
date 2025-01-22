package com.scierie_application.scierie.type_paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Type_paiementRepository extends JpaRepository<TypePaiement , Long> {

}
