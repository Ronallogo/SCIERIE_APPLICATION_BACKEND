package com.scierie_application.scierie.fournisseur;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {


    @Query(value="select avg(taxe_abbatage) as taxe_moy from fournisseur;" , nativeQuery = true)
    Float taxeMoyenneFournisseur();

    @Query(value="select f.* from fournisseur f "+"join ville v on v.id_ville = f.id_ville"+   
        " where nom_fournisseur like concat('%' , :keyword , '%') or email_fournisseur like concat('%' , :keyword , '%')" +
        "or v.nom_ville like concat('%' , :keyword , '%');" , nativeQuery = true
    )
    List<Fournisseur> search(@Param("keyword") String keyword );

    @Query(value="SELECT nom_fournisseur FROM  fournisseur" , nativeQuery = true)
    List<String> getAllNameFournisseur();


    @Query(value="SELECT taxe_abbatage FROM  fournisseur" , nativeQuery = true)
    List<Float> getAllTaxeFournisseur();
}
