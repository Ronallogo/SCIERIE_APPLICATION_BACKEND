package com.scierie_application.scierie.essence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

  

@EnableJpaRepositories
public interface EssenceRepository extends JpaRepository<Essence , Long> {

    Optional<Essence> findByLibelle(String nom);

    @Query(value="select * from essence e where e.libelle like CONCAT('%',:keyword,'%') or e.abbreviation like CONCAT('%',:keyword,'%')" , nativeQuery = true)
    List<Essence> searchEssences(@Param("keyword")  String keyword);


    @Query(value="SELECT avg(mercuriale) as mercuriale FROM essence" , nativeQuery=true)
    Float mercurialeMoyenne();
    


}
