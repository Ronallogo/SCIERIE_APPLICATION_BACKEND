package com.scierie_application.scierie.colis;

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
@Builder
@Setter
@Entity
@Table(name = "colis")
public class Colis implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_colis ;
    @ManyToOne
    @JoinColumn(name = "id_paiement" , nullable = false)
    private Paiement paiement ;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_colis ;




}
