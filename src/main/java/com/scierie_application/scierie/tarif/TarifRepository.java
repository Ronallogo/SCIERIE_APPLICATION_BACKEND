package com.scierie_application.scierie.tarif;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


@EnableJpaRepositories
public interface TarifRepository extends JpaRepository<Tarif , Long> {
    @Query(value = "select t.* from tarif t " +
            "join essence e on e.id_essence = t.id_essence " +
            "where e.libelle = :keyword ;" , nativeQuery = true)
    List<Tarif> search(@Param("keyword") String keyword);


    @Query(value = "select * from tarif where code_tarif= :code" , nativeQuery = true)
    Optional<Tarif> findByCode(@Param("code") String code);


    @Query(value = "select m.nom_monnaie as nom , count(t.id_tarif) as nbr" +
            "     from monnaie m\n" +
            "     join tarif t on t.id_monnaie = m.id_monnaie" +
            "     group by m.nom_monnaie ;"
            , nativeQuery = true)
    List<Tuple> getAllMonnaieWithTarif() ;

}
