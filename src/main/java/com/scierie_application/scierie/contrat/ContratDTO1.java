package com.scierie_application.scierie.contrat;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContratDTO1 {
     private Long id_contrat ;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_contrat ;
    private String etat_contrat ;
    private Long client ;
    private String monnaie ;
    private Float montant ;
    private String typeContract ;
    private String code_contrat ;
}
