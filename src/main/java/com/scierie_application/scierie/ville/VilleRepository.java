package com.scierie_application.scierie.ville;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;


@EnableJpaRepositories
public interface VilleRepository extends JpaRepository<Ville , Long> {
    @Query(value="SELECT * FROM ville v WHERE v.nom_ville= :nom" , nativeQuery = true)
    Optional<Ville> findByNom_Ville(@Param("nom") String nom);
    /// //
    @Query(value = "select v.* from ville v " +
            "join pays p on p.id_pays = v.id_pays " +
            "where v.nom_ville like    concat('%' , :key , '%') or p.nom_pays like concat('%' , :key , '%');" , nativeQuery = true)
    List<Ville> search(@Param("key") String key);
}
