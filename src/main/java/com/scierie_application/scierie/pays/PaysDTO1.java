package com.scierie_application.scierie.pays;

import lombok.*;

@Builder
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaysDTO1 {
    private Long id_pays ;
    @NonNull
    private String nom_pays ;

}
