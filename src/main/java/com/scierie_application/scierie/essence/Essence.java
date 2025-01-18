package com.scierie_application.scierie.essence;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Essence")
public class Essence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_essence ;
    private String libelle ;
    private String abbreviation ;
    private Float densite ;
    private Float mercuriale ;
    private Float teneur_en_eau ;



    public Essence(
        String libelle ,
        String abreviation ,
        Float mercuriale ,
        Float densite ,
        Float teneur_en_eau
    ){
        this.libelle = libelle ;
        this.abbreviation = abreviation ;
        this.mercuriale = mercuriale ;
        this.densite = densite ;
        this.teneur_en_eau = teneur_en_eau;
    }
}
