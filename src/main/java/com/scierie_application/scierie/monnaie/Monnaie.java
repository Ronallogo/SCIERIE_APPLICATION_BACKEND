package com.scierie_application.scierie.monnaie;

import com.scierie_application.scierie.contrat.Contrat;
import com.scierie_application.scierie.tarif.Tarif;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Monnaie" )

public class Monnaie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_monnaie ;
    private String abbreviation ;
    private String nom_monnaie ;
    @OneToMany(mappedBy = "monnaie" , cascade = CascadeType.ALL)
    private List<Contrat> contrats ;
    @OneToMany(mappedBy = "monnaie" , cascade = CascadeType.ALL)
    private List<Tarif> tarifs ;



    Monnaie(String nom ,String abbreviation){
        this.nom_monnaie = nom ;
        this.abbreviation = abbreviation ;
    }

    Monnaie(Long id ,   String nom ,String abbreviation){
        this.nom_monnaie = nom ;
        this.abbreviation = abbreviation ;
        this.id_monnaie = id ;
    }

}
