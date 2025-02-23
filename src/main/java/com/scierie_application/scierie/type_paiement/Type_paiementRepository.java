package com.scierie_application.scierie.type_paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface Type_paiementRepository extends JpaRepository<TypePaiement , Long> {

    Optional<TypePaiement> findByLibelle(@Param("typePaiement") String typePaiement);
}
