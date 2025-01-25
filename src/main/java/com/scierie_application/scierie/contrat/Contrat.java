package com.scierie_application.scierie.contrat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.client.Client;
import com.scierie_application.scierie.monnaie.Monnaie;
import com.scierie_application.scierie.paiement.Paiement;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Entity
@Table(name = "Contrat")
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contrat ;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_contrat ;
    private String etat_contrat ;
    @ManyToOne
    @JoinColumn(name = "id_client" , nullable = false)
    private Client client ;
    @ManyToOne
    @JoinColumn(name = "id_monnaie" , nullable = false)
    private Monnaie monnaie ;
    private Float montant ;
    private String typeContract ;
    private String code_contrat ;
    @OneToMany(mappedBy = "contrat" , cascade = CascadeType.ALL)
    private List<Paiement> paiements ;


        public  static String generateUUID() {
                return UUID.randomUUID().toString();
        }


}
