package com.scierie_application.scierie.paiement;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.client.Client;
import com.scierie_application.scierie.colis.Colis;
import com.scierie_application.scierie.contrat.Contrat;
import com.scierie_application.scierie.facture.Facture;
import com.scierie_application.scierie.tarif.Tarif;
import com.scierie_application.scierie.type_paiement.TypePaiement;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Entity
@Table(name = "Paiement" )
public class Paiement implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paiement ;
    @ManyToOne
    @JoinColumn(name = "id_client" , nullable = false)
    private Client client ;
    @ManyToOne
    @JoinColumn(name = "id_type_paiement" , nullable = false)
    private TypePaiement type_paiement ;
    @ManyToOne
    @JoinColumn(name = "id_tarif" , nullable = false)
    private Tarif tarif ;
    @ManyToOne
    @JoinColumn(name = "id_contrat" , nullable = false)
    private Contrat contrat ;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_cloture ;

    private String etat_paiement ;

    private String codePaiement ;

    @OneToMany(mappedBy = "paiement" , cascade = CascadeType.ALL)

    private List<Colis> listColis ;

    @OneToMany(mappedBy = "paiement" , cascade = CascadeType.ALL)
    private List<Facture> factures ;
}
