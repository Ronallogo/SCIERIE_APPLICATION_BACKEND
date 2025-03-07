package com.scierie_application.scierie.port;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PortRepository extends JpaRepository<Port, Long> {

    @Query(value = "SELECT p FROM Port p WHERE p.ville = :id_ville", nativeQuery = true)
    List<Port> findByVille(@Param("id_ville") Long id_ville);

    @Query(value = "SELECT p.id_port , p.nom_port , p.id_ville FROM port p "+
    " INNER JOIN ville v ON p.id_ville = v.id_ville"+
    " INNER JOIN pays py ON v.id_pays = py.id_pays"+
    "  WHERE  v.nom_ville LIKE CONCAT('%',:keyword,'%') OR p.nom_port LIKE  CONCAT('%',:keyword,'%') OR py.nom_pays LIKE CONCAT('%',:keyword,'%');",
 
    nativeQuery = true)
    List<Port> findPort(@Param("keyword") String keyword);
}
