package com.scierie_application.scierie.grume;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.essence.Essence;
import com.scierie_application.scierie.ravitaillement.Ravitaillement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Grume" )
public class Grume implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id_grume ;
    @ManyToOne
    private Ravitaillement code_rav ;

    private Float longueur_moy ;
    private Float diam_moy ;
    private Float poids_moy ;
    private Integer quantite ;
    private Float cubage_moy ;
    private Float qualite ;
    @ManyToOne
    @JoinColumn(name = "id_essence" , nullable = false) 
    private Essence essence ;
    private Float poids_lots_grume ;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
        timezone = "UTC")
    private Date entree ;
    private boolean traiter ;



}
