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
    @JsonProperty("id_ville")
    private Long id_ville ;
    @JsonProperty("nom_ville")
    private String nom_ville ;
    @JsonProperty("id_pays")
    private Long id_pays ;
    @JsonProperty("nom_pays")
    private String nom_pays ;
}
