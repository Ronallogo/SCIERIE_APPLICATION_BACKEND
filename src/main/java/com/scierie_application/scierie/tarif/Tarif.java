package com.scierie_application.scierie.tarif;

import com.scierie_application.scierie.essence.Essence;
import com.scierie_application.scierie.monnaie.Monnaie;
import com.scierie_application.scierie.paiement.Paiement;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
 
import java.io.Serializable;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Tarif")
public class Tarif implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarif;
    private String code_tarif;
    @ManyToOne
    @JoinColumn(name = "id_essence" , nullable = false)
    private Essence essence ;
    private Float diam_moy ;
    private Float long_moy ;
    private Float montant_unitaire ;
    @ManyToOne
    @JoinColumn(name = "id_monnaie" , nullable = false)
    private Monnaie  monnaie ;

    @OneToMany(mappedBy = "tarif" , cascade = CascadeType.ALL)
    private List<Paiement> paiements ;














}
