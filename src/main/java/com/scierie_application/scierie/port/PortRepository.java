package com.scierie_application.scierie.port;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PortRepository extends JpaRepository<Port , Long> {



    @Query(value = "SELECT p FROM Port p WHERE p.ville = :id_ville" , nativeQuery = true)    
    List<Port> findByVille(@Param("id_ville") Long id_ville);
}
