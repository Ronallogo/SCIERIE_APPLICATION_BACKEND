package com.scierie_application.scierie.traitement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scierie_application.scierie.handler.exeption.TraitementNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TraitementService {

    @Autowired
    private TraitementRepository tr ; 


    public TraitementDTO1 create(TraitementDTO1 t){
        this.tr.save(
            Traitement.builder()
            .bois_a_traiter(t.getBois_a_traiter())
            .description(t.getDescription())
            .nom_traitement(t.getNom_traitement())
            .pourcent_reduction_cubage(t.getPourcent_reduction_cubage())
            .pourcent_reduction_diam(t.getPourcent_reduction_diam())
            .pourcent_reduction_poids(t.getPourcent_reduction_poids())
            .pourcent_reduction_long(t.getPourcent_reduction_long())
            .build()
        );
        

        return t ; 
    }
    

    public TraitementDTO1 edit(TraitementDTO1 t){
        if(!this.tr.existsById(t.getId_traitement())) throw new TraitementNotFoundException("traitement not found");

        this.tr.save(
            Traitement.builder()
            .id_traitement(t.getId_traitement())
            .bois_a_traiter(t.getBois_a_traiter())
            .description(t.getDescription())
            .nom_traitement(t.getNom_traitement())
            .pourcent_reduction_cubage(t.getPourcent_reduction_cubage())
            .pourcent_reduction_diam(t.getPourcent_reduction_diam())
            .pourcent_reduction_long(t.getPourcent_reduction_long())
            .pourcent_reduction_poids( t.getPourcent_reduction_poids())
            .build()
        );
        return t ; 
    }



    public List<TraitementDTO1> getAllTraitement(){
        return this.tr.findAll().stream().map(
            x-> 
            TraitementDTO1.builder()
            .id_traitement(x.getId_traitement())
            .bois_a_traiter(x.getBois_a_traiter())
            .description(x.getDescription())
            .nom_traitement(x.getNom_traitement())
            .pourcent_reduction_cubage(x.getPourcent_reduction_cubage())
            .pourcent_reduction_diam(x.getPourcent_reduction_diam())
            .pourcent_reduction_long(x.getPourcent_reduction_long())
            .pourcent_reduction_poids( x.getPourcent_reduction_poids())
            .build()

        ).collect( Collectors.toList());

    }


    public boolean delete(Long id_traitement){
        if(!this.tr.existsById(id_traitement)) throw new TraitementNotFoundException("traitement not found");
        this.tr.deleteById(id_traitement);
        return true ;
    }

    public List<TraitementDTO1> search(String keyword){
        return this.tr.findByKeyword(keyword).stream().map(
                x->
                        TraitementDTO1.builder()
                                .id_traitement(x.getId_traitement())
                                .bois_a_traiter(x.getBois_a_traiter())
                                .description(x.getDescription())
                                .nom_traitement(x.getNom_traitement())
                                .pourcent_reduction_cubage(x.getPourcent_reduction_cubage())
                                .pourcent_reduction_diam(x.getPourcent_reduction_diam())
                                .pourcent_reduction_long(x.getPourcent_reduction_long())
                                .pourcent_reduction_poids( x.getPourcent_reduction_poids())
                                .build()

        ).collect( Collectors.toList());
    }

    List<TraitementDTO1> getAllByEssence(String essence){
        return this.tr.findTraitementByEssence(essence).stream().map(
                x->
                        TraitementDTO1.builder()
                                .id_traitement(x.getId_traitement())
                                .bois_a_traiter(x.getBois_a_traiter())
                                .description(x.getDescription())
                                .nom_traitement(x.getNom_traitement())
                                .pourcent_reduction_cubage(x.getPourcent_reduction_cubage())
                                .pourcent_reduction_diam(x.getPourcent_reduction_diam())
                                .pourcent_reduction_long(x.getPourcent_reduction_long())
                                .pourcent_reduction_poids( x.getPourcent_reduction_poids())
                                .build()

        ).collect( Collectors.toList());
    }


}
