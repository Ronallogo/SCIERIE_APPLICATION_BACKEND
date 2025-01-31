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
@Getter
@Builder
@Setter
@Entity
@Table(name = "Ville")
public class Ville implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ville ;
    private String nom_ville ;
    @ManyToOne
    @JoinColumn(name = "id_pays" , nullable = false)
    private Pays pays ;
    @OneToMany(mappedBy = "ville" , cascade = CascadeType.ALL)
    private List<Port> ports ;
    @OneToMany(mappedBy = "ville" , cascade = CascadeType.ALL)
    private List<Fournisseur> fournisseurs ; 
 



}
