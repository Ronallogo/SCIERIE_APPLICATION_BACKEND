package com.scierie_application.scierie.ravitaillement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.fournisseur.Fournisseur;
import com.scierie_application.scierie.grume.Grume;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Builder
@Data
 

@Table(name = "Ravitaillement")
 
public class Ravitaillement  implements Serializable {
 
    @Id
    private String code_rav ; 
    @ManyToOne
    @JoinColumn(name = "id_fournisseur" , nullable = false)
    private Fournisseur  fournisseur  ; 

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_rav ;
    private Float prix_rav ;  
    @OneToMany(mappedBy = "code_rav" , cascade = CascadeType.ALL)
    private List<Grume> grumes ;
    private Boolean effectuer ; 
    private Integer qtBois ;
    private Integer  capacite ;


} 
