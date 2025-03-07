package com.scierie_application.scierie.traitement;

import java.io.Serializable;
import java.util.List;

import com.scierie_application.scierie.grume.GrumeTraiter;

import jakarta.persistence.*;

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
@Entity
@Table(name = "Traitement")
public class Traitement  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_traitement ; 
    private String nom_traitement ; 
    private String description ; 
    private String bois_a_traiter ;
    private Float pourcent_reduction_long ;
    private Float pourcent_reduction_diam ;
    private Float pourcent_reduction_poids ;
    private Float pourcent_reduction_cubage ;


    @OneToMany(mappedBy = "traitement" , cascade = CascadeType.ALL)
    private List<GrumeTraiter> listGrumeTraiter ;
    


}
