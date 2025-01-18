package com.scierie_application.scierie.client;

import com.scierie_application.scierie.societe.Societe;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Client" )
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client ;
    @ManyToOne
    private Societe societe ;
    private String adresse ;
    private String email ;
    private String fax ;

    public Client(
        Societe societe ,
        String  adresse ,
        String email ,
        String fax

    ){
         this.adresse  = adresse ;
         this.email = email ;
         this.fax = fax ;
         this.societe = societe ;
    }
}
