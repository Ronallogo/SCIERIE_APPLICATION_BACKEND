package com.scierie_application.scierie.essence;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import com.scierie_application.scierie.grume.Grume;


@Entity
@Data
@Getter
@Setter
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

    @OneToMany(mappedBy = "essence" , cascade = CascadeType.ALL)
    private List<Grume> grumes ; 




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
    Essence(){}
    public Essence(Long id_essence, String libelle, String abbreviation, Float densite, Float mercuriale, Float teneur_en_eau) {
        this.id_essence = id_essence;
        this.libelle = libelle;
        this.abbreviation = abbreviation;
        this.densite = densite;
        this.mercuriale = mercuriale;
        this.teneur_en_eau = teneur_en_eau;
    }

    
    
}
