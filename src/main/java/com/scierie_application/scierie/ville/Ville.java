package com.scierie_application.scierie.ville;


import com.scierie_application.scierie.fournisseur.Fournisseur;
import com.scierie_application.scierie.pays.Pays;
import com.scierie_application.scierie.port.Port;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
 
@Builder
 
@Entity
@Table(name = "Ville")
public class Ville implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id_ville ;
    @Getter
    @Setter
    private String nom_ville ;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_pays" , nullable = false)
    private Pays pays ;
    @OneToMany(mappedBy = "ville" , cascade = CascadeType.ALL)
    private List<Port> ports ;
    @OneToMany(mappedBy = "ville" , cascade = CascadeType.ALL)
    private List<Fournisseur> fournisseurs ; 
 



}
