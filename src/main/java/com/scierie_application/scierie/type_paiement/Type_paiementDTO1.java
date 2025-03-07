package com.scierie_application.scierie.type_paiement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Type_paiementDTO1 {
    private Long id_type_paiement  ;
    private String libelle  ;
    private Integer nbrTranche ;
}
