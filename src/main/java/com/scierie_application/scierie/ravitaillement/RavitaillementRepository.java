package com.scierie_application.scierie.ravitaillement;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RavitaillementRepository  extends JpaRepository<Ravitaillement,String>{



    @Query(value="select * from ravitaillement where code_rav = :code" , nativeQuery=true)
    Optional<Ravitaillement> findByCode(@Param("code") String code);

    @Query(value="select r.* from ravitaillement r "+"join fournisseur f on f.id_fournisseur = r.id_fournisseur" + //
                "where f.nom_fournisseur like concat('%' , :keyword , '%') or r.code_rav like concat('%' , :keyword , '%');"  , nativeQuery = true)
    List<Ravitaillement>search(@Param("keyword") String keyword);
}
