package com.scierie_application.scierie.type_paiement;


import com.scierie_application.scierie.paiement.Paiement;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Type_paiement" )
public class TypePaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type_paiement  ;
    private String libelle  ;
    private Integer nbrTranche ;
    @OneToMany(mappedBy = "type_paiement")
    private List<Paiement> paiements ;
}
