package com.scierie_application.scierie.bille;

import com.scierie_application.scierie.colis.Colis;
import com.scierie_application.scierie.grume.Grume;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BilleDTO1 {
    private Long id_bille ;
    private String codeLot ;
    private Float long_moy ;
    private Float diam_moy ;
    private Float cubage_moy ;
    private Integer quantite ;
    private Float poids_moyen ;
    private Float poids_lots ;

    private String grume ;

    private String colis ;
}
