package com.scierie_application.scierie.ravitaillement;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
 

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RavitaillementDTO1 {
    private Long id_rav ; 
    private Long id_fournisseur ; 
    private String nom_fournisseur  ; 
    private String code_rav ; 
     @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_rav ;
    private Float prix_rav ; 
    private Boolean effectuer ;
    private Integer qtBois ;
    private Integer capacite ;
}
