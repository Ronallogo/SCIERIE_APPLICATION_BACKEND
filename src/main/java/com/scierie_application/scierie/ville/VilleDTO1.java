package com.scierie_application.scierie.ville;

 
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VilleDTO1 {
   
    private Long id_ville ;
  
    private String nom_ville ;
 
    private Long id_pays ;
  
    private String nom_pays ;
}
