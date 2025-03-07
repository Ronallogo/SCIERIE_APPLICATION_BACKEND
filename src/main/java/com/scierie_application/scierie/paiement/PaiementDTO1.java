package com.scierie_application.scierie.paiement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.client.Client;
import com.scierie_application.scierie.contrat.Contrat;
import com.scierie_application.scierie.tarif.Tarif;
import com.scierie_application.scierie.type_paiement.TypePaiement;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PaiementDTO1 {

    private Long id_paiement ;

    private Long id_client ;

    private String type_paiement ;

    private String tarif ;

    private String contrat ;

    private Float montant ;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_cloture ;
    private String codePaiement ;
}
