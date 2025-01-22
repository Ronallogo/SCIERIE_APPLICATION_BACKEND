package com.scierie_application.scierie.pays;


import com.scierie_application.scierie.ville.Ville;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Entity
@Table(name = "Pays")
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pays ;
    @NonNull
    private String nom_pays ;
    @OneToMany(mappedBy = "pays" ,cascade = CascadeType.ALL)
    private List<Ville> villes;


    public Pays(String nom_pays){this.nom_pays = nom_pays;}

    public Pays(Long id_pays , String nom_pays){
        this.id_pays = id_pays ;
        this.nom_pays = nom_pays ;
    }

}
