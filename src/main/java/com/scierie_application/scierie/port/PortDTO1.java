package com.scierie_application.scierie.port;
 
import com.scierie_application.scierie.ville.VilleDTO1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortDTO1 {

    private Long id_port ;
    private String nom_port ;
    private VilleDTO1 ville ;


}
