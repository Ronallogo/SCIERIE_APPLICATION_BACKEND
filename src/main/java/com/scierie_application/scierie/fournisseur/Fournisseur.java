package com.scierie_application.scierie.fournisseur;

import java.io.Serializable;

import com.scierie_application.scierie.ville.Ville;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Fournisseur" )

public class Fournisseur implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fournisseur ;
    private String nom_fournisseur ;
    private String adresse_fournisseur ;
    private String email_fournisseur ;
    private String fax_fournisseur ;
    private String telephone_fournisseur ;
    private Float taxe_abbatage ; 
    @ManyToOne
    @JoinColumn(name = "id_ville" , nullable = false)
    private Ville ville ;
    
    
    
}
