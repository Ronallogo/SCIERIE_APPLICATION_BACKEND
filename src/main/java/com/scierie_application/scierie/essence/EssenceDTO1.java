package com.scierie_application.scierie.essence;


import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EssenceDTO1 {
    private Long id_essence ;
    private String libelle ;
    private String abbreviation ;
    private Float densite ;
    private Float mercuriale ;
    private Float teneur_en_eau ;

}
