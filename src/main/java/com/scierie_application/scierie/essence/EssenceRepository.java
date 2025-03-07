package com.scierie_application.scierie.essence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

  

@EnableJpaRepositories
public interface EssenceRepository extends JpaRepository<Essence , Long> {



    @Query(value="select * from essence e where e.libelle like CONCAT('%',:keyword,'%') or e.abbreviation like CONCAT('%',:keyword,'%')" , nativeQuery = true)
    List<Essence> searchEssences(@Param("keyword")  String keyword);


    @Query(value="SELECT avg(mercuriale) as mercuriale FROM essence" , nativeQuery=true)
    Float mercurialeMoyenne();

    Optional<Essence> findByLibelle(@Param("libelle") String libelle);


    @Query(value = "select e.* from essence e " +
            "join grume g on g.id_essence = e.id_essence " +
            "group by e.id_essence " +
            "order by  count(e.id_essence) desc limit 1;" , nativeQuery = true)
    Essence essenceLePlusAcheter();

    Boolean existsByLibelle(String libelle);


}
