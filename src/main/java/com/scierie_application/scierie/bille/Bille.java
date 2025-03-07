package com.scierie_application.scierie.bille;

import java.io.Serializable;

import com.scierie_application.scierie.colis.Colis;
import com.scierie_application.scierie.grume.Grume;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bille")

public class Bille implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bille ;
    private String codeLot ;
    private Float long_moy ;
    private Float diam_moy ;
    private Float cubage_moy ;
    private Integer quantite ;
    private Float poids_moyen ;
    private Float poids_lots ;
    @ManyToOne
    @JoinColumn(name = "id_grume")
    private Grume grume ;
    @ManyToOne
    @JoinColumn(name = "id_colis")
    private Colis colis ;
    
    


}
