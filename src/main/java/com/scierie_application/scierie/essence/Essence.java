package com.scierie_application.scierie.essence;


import jakarta.persistence.*;


import java.io.Serializable;


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
    Essence(){}
    public Essence(Long id_essence, String libelle, String abbreviation, Float densite, Float mercuriale, Float teneur_en_eau) {
        this.id_essence = id_essence;
        this.libelle = libelle;
        this.abbreviation = abbreviation;
        this.densite = densite;
        this.mercuriale = mercuriale;
        this.teneur_en_eau = teneur_en_eau;
    }

    public Long getId_essence() {
        return id_essence;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Float getDensite() {
        return densite;
    }

    public Float getMercuriale() {
        return mercuriale;
    }

    public Float getTeneur_en_eau() {
        return teneur_en_eau;
    }
}
