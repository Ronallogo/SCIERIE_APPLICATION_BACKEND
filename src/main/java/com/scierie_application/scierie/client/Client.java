package com.scierie_application.scierie.client;

import com.scierie_application.scierie.contrat.Contrat;
import com.scierie_application.scierie.paiement.Paiement;
import com.scierie_application.scierie.societe.Societe;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Client" )
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id_client ;
    @Getter
    @Setter
    @ManyToOne
    private Societe societe ;
    @Getter
    @Setter
    private String adresse ;
    @Getter
    @Setter
    private String email ;
    @Getter
    @Setter
    private String fax ;
    @OneToMany(mappedBy = "client"  , cascade = CascadeType.ALL)
    private List<Contrat> contrats ;
    @OneToMany(mappedBy = "client"  , cascade = CascadeType.ALL)
    private List<Paiement> paiements ;

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

	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public List<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	
    
    
    
    
    
    
    
    
}
