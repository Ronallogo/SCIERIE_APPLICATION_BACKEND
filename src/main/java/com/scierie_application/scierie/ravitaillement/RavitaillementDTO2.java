package com.scierie_application.scierie.ravitaillement;


import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter
@Builder
@Data
public class RavitaillementDTO2 {
    Integer nbr_rav ;
    Integer month ;
}
