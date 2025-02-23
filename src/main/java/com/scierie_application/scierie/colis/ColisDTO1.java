package com.scierie_application.scierie.colis;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.paiement.Paiement;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter

public class ColisDTO1 {
    private Long id_colis ;

    private Long paiement ;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_colis ;
}
