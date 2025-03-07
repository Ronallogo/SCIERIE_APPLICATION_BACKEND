package com.scierie_application.scierie.paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


@EnableJpaRepositories
public interface PaiementRepository extends JpaRepository<Paiement , Long> {


    @Query(value="select * from paiement where code_paiement= :code;" , nativeQuery = true)
    Optional<Paiement> findByCode(@Param("code") String code);
}
