package com.scierie_application.scierie.traitement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraitementDTO1 {
    private Long id_traitement ; 
    private String nom_traitement ; 
    private String description ; 
    private String bois_a_traiter ;
    private Float pourcent_reduction_long ;
    private Float pourcent_reduction_diam ;
    private Float pourcent_reduction_poids ;
    private Float pourcent_reduction_cubage ; 

}
