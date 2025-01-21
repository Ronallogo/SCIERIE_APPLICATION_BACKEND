package com.scierie_application.scierie.facture;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.paiement.Paiement;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Facture" )
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_facture ;
    private Float montant ;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_facture ;
    @ManyToOne
    @JoinColumn(name = "id_paiement" , nullable = false)
    private Paiement paiement ;
}
