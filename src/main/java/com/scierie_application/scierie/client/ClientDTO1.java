package com.scierie_application.scierie.client;

 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
/// /
public class ClientDTO1 {
	 
    private  Long id_client ;
 
    private Long id_societe ;
	 
    private String societe ;
 
    private String adresse ;
	 
    private String email ;
	 
    private String fax  ;

 
    
 

    
}
