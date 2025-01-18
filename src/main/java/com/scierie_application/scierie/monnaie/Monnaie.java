package com.scierie_application.scierie.monnaie;

import com.scierie_application.scierie.paiement.Paiement;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Monnaie" )

public class Monnaie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_monnaie ;
    private String abbreviation ;
    private String nom_monnaie ;
    @OneToMany(mappedBy = "monnaie" , cascade = CascadeType.ALL)
    private List<Paiement> paiements ;



    Monnaie(String nom ,String abbreviation){
        this.nom_monnaie = nom ;
        this.abbreviation = abbreviation ;
    }

}
