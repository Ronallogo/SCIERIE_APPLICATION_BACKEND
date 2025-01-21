package com.scierie_application.scierie.societe;

import com.scierie_application.scierie.client.Client;
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
@Table(name = "Societe")
public class Societe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_societe ;
    @NonNull
    private String nom_societe ;
    @OneToMany(mappedBy = "societe" , cascade = CascadeType.ALL)
    private List<Client> clients;

    Societe(String nom_societe){ this.nom_societe = nom_societe;}
}
