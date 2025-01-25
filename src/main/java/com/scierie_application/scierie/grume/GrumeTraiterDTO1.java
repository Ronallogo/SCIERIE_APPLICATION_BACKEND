package com.scierie_application.scierie.grume;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
 

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class GrumeTraiterDTO1 {

    private Long id_operation ; 
    private String code_grume;
    
    private Long id_traitement;
    private String nom_traitement ; 
    private String bois_associe ; 
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_traitement;
}
