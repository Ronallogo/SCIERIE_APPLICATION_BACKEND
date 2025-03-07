package com.scierie_application.scierie.fournisseur;

 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
 
public class FournisseurDTO1 {
    private Long id_fournisseur ;
    private String nom_fournisseur ;
    private String adresse_fournisseur ;
    private String email_fournisseur ;
    private String fax_fournisseur ;
    private String telephone_fournisseur ;
    private Float taxe_abbatage ; 
    private Long id_ville ;
    private String nom_ville ;
}
