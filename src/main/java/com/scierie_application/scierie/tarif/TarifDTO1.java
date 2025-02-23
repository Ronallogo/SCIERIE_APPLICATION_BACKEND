package com.scierie_application.scierie.tarif;

import com.scierie_application.scierie.essence.Essence;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class TarifDTO1 {
    private Long id_tarif;
    private String code_tarif;

    private String essence ;
    private Float diam_moy ;
    private Float long_moy ;
    private Float montant_unitaire ;
}
