package com.scierie_application.scierie.grume;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrumeTraiteRepository extends JpaRepository<GrumeTraiter,Long>{

}
