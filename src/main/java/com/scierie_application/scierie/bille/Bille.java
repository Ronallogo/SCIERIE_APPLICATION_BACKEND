package com.scierie_application.scierie.bille;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Bille")
public class Bille implements Serializable{
    private Long id_bille ; 
}
