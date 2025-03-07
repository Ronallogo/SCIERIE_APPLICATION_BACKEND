package com.scierie_application.scierie.grume;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
 

@EnableJpaRepositories
public interface GrumeRepository  extends JpaRepository<Grume,Long>{
    @Query(value = "select * from grume g where g.code_rav_code_rav = :nom" , nativeQuery = true)
    Optional<Grume> findByCodeLots(@Param("nom") String nom);

    @Query(value="select g.* from grume g join essence e on e.id_essence = g.id_essence where e.libelle like  concat('%' , :keyword , '%') or g.code_rav_code_rav like concat('%' , :keyword , '%');" , nativeQuery = true)
    List<Grume> search(@Param("keyword") String keyword);

    @Query(value = "select sum(g.quantite) from grume g " +
            " join essence e on e.id_essence = g.id_essence " +
            "  where e.libelle = :essence and g.traiter = b'0'" , nativeQuery = true)
    Integer grumeNonTraiter(@Param("essence") String essence) ;
    @Query(value = "select sum(g.quantite) from grume g " +
            "join essence e on e.id_essence = g.id_essence " +
            "  where e.libelle = :essence and g.traiter = b'1'" , nativeQuery = true)
    Integer grumeTraiter(@Param("essence") String essence) ;


    @Query(value = "select sum(g.quantite) from grume g " +
            "join essence e on e.id_essence = g.id_essence " +
            "  where e.libelle = :essence " , nativeQuery = true)
    Integer totalGrumeByEssence(@Param("essence") String essence);


}
