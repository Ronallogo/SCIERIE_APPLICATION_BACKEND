package com.scierie_application.scierie.colis;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.essence.EssenceDTO1;
import com.scierie_application.scierie.paiement.Paiement;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter

public class ColisDTO1 {
    private Long id_colis ;

    private String paiement ;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_colis ;
    private Integer nbrBois ;
    List<EssenceDTO1> essences ;
}
