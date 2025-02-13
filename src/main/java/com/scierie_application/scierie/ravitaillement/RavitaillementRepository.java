package com.scierie_application.scierie.ravitaillement;

import java.util.List;
import java.util.Optional;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RavitaillementRepository  extends JpaRepository<Ravitaillement,String>{



    @Query(value="select * from ravitaillement where code_rav = :code" , nativeQuery=true)
    Optional<Ravitaillement> findByCode(@Param("code") String code);

    @Query(value = "SELECT r.* FROM ravitaillement r " +
            "JOIN fournisseur f ON f.id_fournisseur = r.id_fournisseur " +
            "WHERE f.nom_fournisseur LIKE CONCAT('%', :keyword, '%') OR r.code_rav LIKE CONCAT('%', :keyword, '%');", nativeQuery = true)
    List<Ravitaillement> search(@Param("keyword") String keyword);

    @Modifying
    @Query(value = "DELETE FROM ravitaillement WHERE code_rav = :code", nativeQuery = true)
    void removeByCode(@Param("code") String code);


    @Query(value = "SELECT COUNT(month(date_rav)) AS nbr_rav , MONTH(date_rav) AS month FROM ravitaillement r WHERE  YEAR(date_rav) = :year GROUP BY MONTH(date_rav) ORDER BY COUNT(MONTH(r.date_rav)) DESC; " , nativeQuery = true)
     List<RavitaillementDTO2> nbrRavParMois(@Param("year") String year);


/// //select   count(month(date_rav)) , month(date_rav) from ravitaillement r
/// where year(date_rav) = '2025'
///  group by month(date_rav)
///  order by count(month(r.date_rav)) desc;




}

