package com.scierie_application.scierie.grume;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GrumeTraiteRepository extends JpaRepository<GrumeTraiter,Long>{


    @Query(value = "select gtr.id_grume from grume_traiter gtr join grume g on gtr.id_grume = g.id_grume ; " , nativeQuery = true)
    List<Long> getAllGrumeTraitsId(); //


    @Query(value = "select count(gt.id_operation) from grumeTraiter gt " +
            "join grume g on g.id_grume = gt.id_grume " +
            "join essence e on e.id_essence = g.id_essence" +
            "  where e.libelle = :essence" , nativeQuery = true)
    Integer grumeTraiter(@Param("essence") String essence) ;
}
