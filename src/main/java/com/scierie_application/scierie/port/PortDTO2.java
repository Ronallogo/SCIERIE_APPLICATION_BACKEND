package com.scierie_application.scierie.port;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortDTO2 {

    private Long id_port ;
    private String nom_port ;
    @JsonProperty("id_ville")
    private Long id_ville ;
    @JsonProperty("nom_ville")
    private String nom_ville ;
    @JsonProperty("id_pays")
    private Long id_pays ;
    @JsonProperty("nom_pays")
    private String nom_pays ;

}
