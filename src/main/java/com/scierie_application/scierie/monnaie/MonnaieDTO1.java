package com.scierie_application.scierie.monnaie;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonnaieDTO1 {
    private Long id_monnaie ;
    @NonNull
    private String abbreviation ;
    private String nom_monnaie ;
    
}
