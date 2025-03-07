package com.scierie_application.scierie.grume;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scierie_application.scierie.traitement.Traitement;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "Grume_Traiter" )
public class GrumeTraiter  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_operation ; 
    @OneToOne
    @JoinColumn(name ="id_grume")
    private Grume grume;
    @ManyToOne
    @JoinColumn(name = "id_traitement" , nullable = false)
    private Traitement traitement;
     @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "UTC")
    private Date date_traitement;
    private Float cubageApresTraitement ;
    private Float LongApresTraitement ;
    private Float diamApresTraitement ;
    private Float poidsApresTraitement ;
}
