package com.scierie_application.scierie.ravitaillement;

 
import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.fournisseur.Fournisseur;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ravitaillement")
@Data
public class Ravitaillement  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id_rav ; 
    private Fournisseur  fournisseur  ; 
    private String code_rav ; 
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_rav ;
    private Float prix_rav ; 


}
