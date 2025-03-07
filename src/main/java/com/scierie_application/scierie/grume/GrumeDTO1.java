package com.scierie_application.scierie.grume;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GrumeDTO1 {
    private Long id_grume ;
    private String code_lots ;

    private Float longueur_moy ;
    private Float diam_moy ;
    private Float poids_moy ;
    private Float cubage_moy ;
    private Float qualite ;
    private Integer quantite ; 
    private Long id_essence ;
    private String nom_essence ; 
    private boolean traiter ; 

    @JsonFormat(shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
        timezone = "UTC")
    private Date entree ; 

}
