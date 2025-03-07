package com.scierie_application.scierie.fournisseur;


import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FournisseurDTO2 {
    private List<String> nom_fournisseurs ;
    private List<Float> taxe_abbatages ;
}
