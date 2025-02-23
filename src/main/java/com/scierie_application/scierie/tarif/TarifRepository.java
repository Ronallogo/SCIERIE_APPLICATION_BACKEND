package com.scierie_application.scierie.tarif;

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

}
