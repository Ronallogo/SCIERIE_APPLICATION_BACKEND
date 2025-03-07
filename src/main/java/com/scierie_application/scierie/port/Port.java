package com.scierie_application.scierie.port;

import com.scierie_application.scierie.ville.Ville;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Port" )

public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_port ;
    private String nom_port ;
    @ManyToOne
    @JoinColumn(name = "id_ville" , nullable = true)
    private Ville ville ;
}
