package com.scierie_application.scierie.traitement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TraitementRepository  extends JpaRepository<Traitement , Long>{


    @Query(value = "select * from traitement t " +
            "where t.nom_traitement  like concat('%' , :keyword , '%') or t.bois_a_traiter like concat('%' , :keyword , '%') ;" , nativeQuery = true)
    List<Traitement> findByKeyword(@Param("keyword") String keyword);

    @Query(value="select e.libelle from traitement t " +
            "join essence on" , nativeQuery = true)
    String getEssenceWithMostProcess();
}
