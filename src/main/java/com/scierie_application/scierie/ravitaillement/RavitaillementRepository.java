package com.scierie_application.scierie.ravitaillement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RavitaillementRepository  extends JpaRepository<Ravitaillement,Long>{

}
