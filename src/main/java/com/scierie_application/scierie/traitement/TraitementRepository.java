package com.scierie_application.scierie.traitement;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TraitementRepository  extends JpaRepository<Traitement , Long>{


    @Query(value = "select * from traitement t " +
            "where t.nom_traitement  like concat('%' , :keyword , '%') or t.bois_a_traiter like concat('%' , :keyword , '%') ;" , nativeQuery = true)
    List<Traitement> findByKeyword(@Param("keyword") String keyword);

   @Query(value=" select e.libelle as libelle , count(e.id_essence) as nbr from essence e " +
           "    join traitement t on t.bois_a_traiter = e.libelle\n" +
           "     group by e.id_essence ;" , nativeQuery = true)
    List<Tuple> getEssenceWithMostProcess();


    
    @Query(value = "select  t.* from traitement t " +
            "join essence e on t.bois_a_traiter = e.libelle " +
            "where e.libelle = :essence " , nativeQuery = true)
    List<Traitement>findTraitementByEssence(@Param("essence") String essence);
 
    @Query(value = "select * from traitement t " +
            "where t.nom_traitement = :nom_traitement " , nativeQuery = true)
    Optional<Traitement> findByNom_traitement(String nom_traitement);
}
